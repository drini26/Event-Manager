package com.project.eventmanager.security.service;

import com.project.eventmanager.security.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;


@Data
@AllArgsConstructor
public class JwtUserDetailsImpl implements UserDetails{

    private long id;

    private String username;

    private String password;




    public static JwtUserDetailsImpl build(User user) {

        return new JwtUserDetailsImpl(
                user.getId(),
                user.getUsername(),
                user.getPassword()
        );
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
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
}