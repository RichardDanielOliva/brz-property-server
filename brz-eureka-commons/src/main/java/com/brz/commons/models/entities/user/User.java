package com.brz.commons.models.entities.user;
import java.util.Arrays;import java.util.List;import javax.persistence.Column;
import javax.persistence.Entity;import javax.persistence.EnumType;import javax.persistence.Enumerated;import javax.persistence.FetchType;import javax.persistence.GeneratedValue;import javax.persistence.GenerationType;import javax.persistence.Id;import javax.persistence.JoinTable;import javax.persistence.JoinColumn;import javax.persistence.ManyToMany;import javax.persistence.Table;

/** * Security User Entity. * * Created by  */@Entity@Table(name = "users")public class User {    @Id    @GeneratedValue(strategy = GenerationType.IDENTITY)    @Column(name = "id")    private Long id; 	public User(String username, String email, AuthProvider authProvider, Role role) {        this.username = username;        this.authProvider = authProvider;        this.email = email;        this.roles = Arrays.asList(role);    }	    @Column(name = "enabled")    private boolean enabled;    @Column(name = "username")    private String username;    @Column(name = "password")    private String password;    @Column(name = "first_name")    private String firstName;    @Column(name = "last_name")    private String lastName;        @Column(nullable = false, name="email")    private String email;        @Column(name = "auth_provider")    @Enumerated(EnumType.STRING)    private AuthProvider authProvider;    /**     * Default Constructor.     */    protected User() {    }    @ManyToMany(fetch = FetchType.EAGER)    @JoinTable(name = "user_role",    		joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))    private List<Role> roles;    public Long getId() {        return id;    }    public void setId(Long id) {        this.id = id;    }    public String getUsername() {        return username;    }    public void setUsername(String username) {        this.username = username;    }    public String getPassword() {        return password;    }    public void setPassword(String password) {        this.password = password;    }    public String getFirstName() {        return firstName;    }    public void setFirstName(String firstName) {        this.firstName = firstName;    }    public String getLastName() {        return lastName;    }    public void setLastName(String lastName) {        this.lastName = lastName;    }    public List<Role> getRoles() {        return roles;    }    public void setRoles(List<Role> roles) {        this.roles = roles;    }	public String getEmail() {		return email;	}	public void setEmail(String email) {		this.email = email;	}	public AuthProvider getAuthProvider() {		return authProvider;	}	public void setAuthProvider(AuthProvider authProvider) {		this.authProvider = authProvider;	}	public boolean isEnabled() {		return enabled;	}	public void setEnabled(boolean enable) {		this.enabled = enable;	}	@Override	public String toString() {		return "User [id=" + id + ", username=" + username + ", password=" + password + ", firstName=" + firstName				+ ", lastName=" + lastName + ", email=" + email + ", authProvider=" + authProvider + ", roles=" + roles				+ "]";	}    }
