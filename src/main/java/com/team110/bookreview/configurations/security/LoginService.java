package com.team110.bookreview.configurations.security;


import com.team110.bookreview.dtos.LoginRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class LoginService {
    private final AuthenticationManager userAuthenticationManager;
    private final JwtUtil jwtUtil;
    private final CustomUserDetailService signInService;



    public String authenticate(LoginRequestDto loginDto) throws Exception {
        try {
            userAuthenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException("Invalid Credentials provided");
        }
        final UserDetails userDetails = signInService.loadUserByUsername(loginDto.getEmail());
        return jwtUtil.generateToken(userDetails);
    }
}
