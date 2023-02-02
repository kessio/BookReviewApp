package com.team110.bookreview.configurations.security;

import com.team110.bookreview.entities.User;
import com.team110.bookreview.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class CustomUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String emailOrUsername) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(emailOrUsername)
                .orElseThrow(()-> new UsernameNotFoundException("No user found with username:" + emailOrUsername));
        return new UserAuth(user.getEmail(),user.getPassword(),true);
    }
}
