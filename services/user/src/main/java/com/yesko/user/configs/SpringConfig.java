package com.yesko.user.configs;

import com.yesko.user.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class SpringConfig {

    private final UserRepo repo;

    /**
     * Bean to provide custom implementation of UserDetailsService.
     * This service is responsible for fetching user details from the database by username.
     * If the user is not found, it throws a UsernameNotFoundException.
     *
     * @return UserDetailsService implementation
     */
    @Bean
    public UserDetailsService userDetailsService() {
        return username -> repo.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    /**
     * Bean for configuring the AuthenticationProvider.
     * This uses a DaoAuthenticationProvider, which retrieves user details using the UserDetailsService
     * and validates passwords using the BCrypt password encoder.
     *
     * @return AuthenticationProvider
     */
    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    /**
     * Bean to provide the AuthenticationManager.
     * The AuthenticationManager is responsible for managing authentication processes
     * in the application. It is automatically configured using the AuthenticationConfiguration.
     *
     * @param config AuthenticationConfiguration to retrieve the authentication manager
     * @return AuthenticationManager
     * @throws Exception if any error occurs during retrieval
     */
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    /**
     * Bean to provide a PasswordEncoder.
     * This uses BCryptPasswordEncoder, a password hashing function that is considered secure
     * and widely used for encrypting passwords.
     *
     * @return PasswordEncoder
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
