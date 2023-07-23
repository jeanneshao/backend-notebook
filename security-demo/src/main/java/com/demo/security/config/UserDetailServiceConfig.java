package com.demo.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.Arrays;

/**
 * @author Jeanne 2023/7/17
 **/
@Configuration
public class UserDetailServiceConfig {
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    PasswordEncoder encoder2 = NoOpPasswordEncoder.getInstance();

    @Bean
    public UserDetailsService users() {
        User.UserBuilder userBuilder = User.builder().passwordEncoder(encoder2::encode);

        UserDetails user = userBuilder
                .username("user1")
//                .password( encoder.encode("user"))
                .password( "{noop}user1")
                .roles("USER")
                .authorities(Arrays.asList(
                        new SimpleGrantedAuthority("READ")
                ))
                .build();
        UserDetails admin = userBuilder
                .username("admin")
                .password("{noop}admin")
//                .password(encoder.encode("admin"))
                .roles("USER", "ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user, admin);
    }
}
