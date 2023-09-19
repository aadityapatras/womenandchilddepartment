package womenandchilddepartment.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class Admin implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int uid;
    private String name;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
//				SimpleGrantedAuthority simpleGrantedAuthority=  new SimpleGrantedAuthority(role.toString());
        String roleName = "ROLE_" + "ADMIN";
        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(roleName);

        List<SimpleGrantedAuthority> simpleGrantedAuthorities = new java.util.ArrayList<>();
        simpleGrantedAuthorities.add(simpleGrantedAuthority);
        return simpleGrantedAuthorities;
//				return authorities;
    }
    @Override
    public String getUsername() {
        // TODO Auto-generated method stub
        return email;
    }
    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }
    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return true;
    }
    @Override
    public String toString() {
        return "User [id=" + uid + ", name=" + name + ", email=" + email + ", password=" + password + ", role="
                + role + "]";
    }
}
