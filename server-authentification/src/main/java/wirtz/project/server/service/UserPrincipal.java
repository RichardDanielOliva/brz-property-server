package wirtz.project.server.service;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import wirtz.project.server.persistence.entities.User;

import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UserPrincipal implements OAuth2User, UserDetails{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user;
    private Map<String, Object> attributes;

    public UserPrincipal(User user){
        super();
        this.user = user;
    }
    
    public UserPrincipal(User user, Map<String, Object> attributes){
        super();
        this.user = user;
        this.attributes = attributes;
    }
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(null==user.getRoles()){
            return Collections.emptySet();
        }
        
        Set<SimpleGrantedAuthority> grantedAuthorities = new HashSet<>();
        user.getRoles().forEach(role->{
           grantedAuthorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        });
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return this.user.getPassword();
    }

    @Override
    public String getUsername() {
        return this.user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

	@Override
	public String getName() {
		return String.valueOf(this.user.getId());
	}

	@Override
	public Map<String, Object> getAttributes() {
		return attributes;
	}

	public void setAttributes(Map<String, Object> attributes) {
		this.attributes = attributes;
	}

	@Override
	public String toString() {
		return "UserPrincipal [user=" + user + ", attributes=" + attributes + "]";
	}
	
	
}
