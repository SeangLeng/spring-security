package com.security.springsecuritybasic.service;

import com.security.springsecuritybasic.model.Account;
import com.security.springsecuritybasic.repository.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class AccountService implements UserDetailsService {
    private final UserRepository userRepository;
    AccountService (UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Account user = userRepository.findUserByEmail(email);
        List<String> roles = Arrays.asList(user.getRole());
        return User.builder()
                .username(user.getEmail())
                .password(user.getPasscode())
                .roles("USER")
                .build();
    }
}
