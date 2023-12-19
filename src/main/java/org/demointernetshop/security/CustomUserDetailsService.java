package org.demointernetshop.security;

import lombok.AllArgsConstructor;
import org.demointernetshop.entity.Role;
import org.demointernetshop.entity.User;
import org.demointernetshop.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found with email: " + email));

        Set<GrantedAuthority> authorities = new HashSet<>();
        Role userRole = user.getRole();

        if (userRole != null) {
            authorities.add(new SimpleGrantedAuthority(userRole.getName()));
        }

        return new org.springframework.security.core.userdetails.User(
                email,
                user.getPassword(),
                authorities);
    }
}
