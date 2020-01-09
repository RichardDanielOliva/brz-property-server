package wirtz.project.server.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.authority.mapping.GrantedAuthoritiesMapper;
import org.springframework.security.core.authority.mapping.SimpleAuthorityMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfigurationSource;

import wirtz.project.server.config.oAuth2.HttpCookieOAuth2AuthorizationRequestRepository;
import wirtz.project.server.config.oAuth2.OAuth2AuthenticationFailureHandler;
import wirtz.project.server.config.oAuth2.OAuth2AuthenticationSuccessHandler;
import wirtz.project.server.exception.RestAuthenticationEntryPoint;
import wirtz.project.server.service.CustomOAuth2UserService;
import wirtz.project.server.service.UserDetailsServiceImpl;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
    private UserDetailsServiceImpl userDetailsService; 
    private CustomOAuth2UserService customOAuth2UserService;
    private OAuth2AuthenticationSuccessHandler oAuth2AuthenticationSuccessHandler;
    private OAuth2AuthenticationFailureHandler oAuth2AuthenticationFailureHandler;
    private CorsConfigurationSource corsConfigurationSource;
    
    @Autowired
	public WebSecurityConfig(UserDetailsServiceImpl userDetailsService, 
			CustomOAuth2UserService customOAuth2UserService,
			OAuth2AuthenticationSuccessHandler oAuth2AuthenticationSuccessHandler, 
			OAuth2AuthenticationFailureHandler oAuth2AuthenticationFailureHandler,
			CorsConfigurationSource corsConfigurationSource) {
		super();
		this.userDetailsService = userDetailsService;
		this.customOAuth2UserService = customOAuth2UserService;
		this.oAuth2AuthenticationSuccessHandler = oAuth2AuthenticationSuccessHandler;
		this.oAuth2AuthenticationFailureHandler = oAuth2AuthenticationFailureHandler;
		this.corsConfigurationSource = corsConfigurationSource;
	}
    
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(11);
	}
    
    @Bean
    public HttpCookieOAuth2AuthorizationRequestRepository cookieAuthorizationRequestRepository() {
        return new HttpCookieOAuth2AuthorizationRequestRepository();
    }
	
    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(this.userDetailsService);
        provider.setPasswordEncoder(passwordEncoder());
        provider.setAuthoritiesMapper(authoritiesMapper());
        return provider;
    }

    @Bean
    public GrantedAuthoritiesMapper authoritiesMapper(){
        SimpleAuthorityMapper authorityMapper = new SimpleAuthorityMapper();
        authorityMapper.setConvertToUpperCase(true);
        authorityMapper.setDefaultAuthority("USER");
        return authorityMapper;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Bean
	@Override
	public AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}
    
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http
			.cors()
			.configurationSource(corsConfigurationSource)
				.and()
		    .sessionManagement()
		        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		        .and()
		    .csrf()
		        .disable()
		    .formLogin()
		        .disable()
		    .httpBasic()
		        .disable()
		    .exceptionHandling()
                .authenticationEntryPoint(new RestAuthenticationEntryPoint())
		     .and()
                .authorizeRequests()
                    .antMatchers("/oauth2/**, /oauth/token")
                        .permitAll()
                    .anyRequest()
                        .authenticated()
                    .and()
                .oauth2Login()
                    .authorizationEndpoint()
                        .baseUri("/oauth2/authorize")
                        .authorizationRequestRepository(cookieAuthorizationRequestRepository())
                        .and()
                    .redirectionEndpoint()
                        .baseUri("/oauth2/callback/*")
                        .and()
                    .userInfoEndpoint()
                        .userService(customOAuth2UserService)
                        .and()
                    .successHandler(oAuth2AuthenticationSuccessHandler)
                    .failureHandler(oAuth2AuthenticationFailureHandler);
	}
}
