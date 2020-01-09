package wirtz.project.server.config;

import java.util.Arrays;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
	private AuthenticationManager authenticationManager;
	private BCryptPasswordEncoder passwordEncoder;
	private String tokenSecretKey;
	
	@Autowired
	public AuthorizationServerConfig(
			@Value("${security.jwt.token.secret-key}") String tokenSecretKey,
			AuthenticationManager authenticationManager,
			BCryptPasswordEncoder passwordEncoder) {
		super();
		this.authenticationManager = authenticationManager;
		this.passwordEncoder = passwordEncoder;
		this.tokenSecretKey = tokenSecretKey;
	}

	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		security
			.tokenKeyAccess("permitAll()")
			.checkTokenAccess("isAuthenticated()"); // ruta /ouath/check_token
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory()
			.withClient("react-app") // incorporar a Base de datos 
			.secret(passwordEncoder.encode("12345"))
			.scopes("read", "write")
			.authorizedGrantTypes("password", "refresh_token") // tipo de consecion del token. usamos password con credenciales, los usiarios existen en BD y sus credenciales tienen que ser enviadas. 
			.accessTokenValiditySeconds(3600) //Cada cuanto tiempo caduca nuestro token.
			.refreshTokenValiditySeconds(3600); //Refresh token
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
		//tokenEnhancerChain.setTokenEnhancers(Arrays.asList(infoAditionalToken, accessTokenConverter()));
		tokenEnhancerChain.setTokenEnhancers(Arrays.asList(accessTokenConverter()));
		
		endpoints
			.authenticationManager(authenticationManager)
			.tokenStore(tokenStore()) //opcional, por defecto si AuthorizationServerEndpointsConfigurer no lo detecta lo crea por debajo.
			.accessTokenConverter(accessTokenConverter())
			.tokenEnhancer(tokenEnhancerChain);
	}

	@Bean
	public JwtTokenStore tokenStore() {
		return new JwtTokenStore(accessTokenConverter());
	}
	

	@Bean
	public JwtAccessTokenConverter accessTokenConverter() {
		JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
		jwtAccessTokenConverter.setSigningKey(tokenSecretKey);
		return jwtAccessTokenConverter;
	}
}
