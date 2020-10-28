package com.javaguides.service;

import com.javaguides.dto.UserRegistrationDto;
import com.javaguides.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    /**
     * Save user.
     *
     * @param registrationDto the registration dto
     * @return the user
     */
    User save(UserRegistrationDto registrationDto);

}
