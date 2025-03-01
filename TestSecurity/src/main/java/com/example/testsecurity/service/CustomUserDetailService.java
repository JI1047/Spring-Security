package com.example.testsecurity.service;


import com.example.testsecurity.dto.CustomUseDetailsDto;
import com.example.testsecurity.entity.User;
import com.example.testsecurity.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService  implements UserDetailsService {

    private final UserRepository userRepository;
    public CustomUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username);
        System.out.println(username);
        if(user != null) {
            return new CustomUseDetailsDto(user);
        }
        return null;
    }
}


