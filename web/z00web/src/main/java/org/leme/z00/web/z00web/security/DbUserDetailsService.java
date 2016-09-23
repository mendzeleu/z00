package org.leme.z00.web.z00web.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by mendzl on 9/20/2016.
 */
public class DbUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        GrantedAuthority ga = new SimpleGrantedAuthority("ROLE_USER");
        List<GrantedAuthority> l = new ArrayList<>();
        l.add(ga);
        UserDetails u = new User("admin", "admin", true, true, true, true, l);
        return u;
    }


}
