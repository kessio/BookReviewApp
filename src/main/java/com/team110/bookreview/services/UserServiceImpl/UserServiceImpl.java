package com.team110.bookreview.services.UserServiceImpl;

import com.team110.bookreview.dtos.UserDto;
import com.team110.bookreview.entities.User;
import com.team110.bookreview.exceptions.UserAlreadyExistException;
import com.team110.bookreview.repository.UserRepository;
import com.team110.bookreview.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User registerNewUser(UserDto userDto) {
        Optional<User> ifExist = userRepository.findByEmail(userDto.getEmail());
        if (ifExist.isPresent()) {
            throw new UserAlreadyExistException("A user with the email " + userDto.getEmail() + " already exists");
        }
        User newUser = new User();
        BeanUtils.copyProperties(userDto, newUser);
        newUser.setUserId(UUID.randomUUID());
        newUser.setPassword(passwordEncoder.encode(userDto.getPassword()));
        return userRepository.save(newUser);
    }
}