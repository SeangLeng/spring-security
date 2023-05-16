package com.security.springsecuritybasic.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    // set up user credential

    // in memory is mainly for testing.
    // h2 -> in memory
//    @Bean
//    public InMemoryUserDetailsManager userDetailService() {
//        UserDetails user = User.withUsername("leng").password("12345").roles("USER").build();
//        UserDetails user2 = User.withUsername("jenzy").password("1234").roles("ADMIN").build();
//        return new InMemoryUserDetailsManager(user, user2);
//    }
//
//    // configuration for the security
    @Bean
    public SecurityFilterChain filterChain (HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/homepage", "/feed", "/email/**")
                .permitAll()
                .requestMatchers("/user/**")
                .hasRole("USER")
                .requestMatchers("/admin/**")
                .hasRole("AMIN")
                .anyRequest()
                .authenticated()
                .and()
                .formLogin();
        return httpSecurity.build();
    }

    // password encoder
    // @Bean
    //    public PasswordEncoder passwordEncoder(){
    //        return new BCryptPasswordEncoder();
    //    }

    @SuppressWarnings("deprecation")  // to remove warning .
    @Bean
    public NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }

}
