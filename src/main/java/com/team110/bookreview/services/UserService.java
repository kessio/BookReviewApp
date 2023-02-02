package com.team110.bookreview.services;

import com.team110.bookreview.dtos.UserDto;
import com.team110.bookreview.entities.User;

public interface UserService {

    User registerNewUser(UserDto userDto);

}