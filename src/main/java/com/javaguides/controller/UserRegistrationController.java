package com.javaguides.controller;

import com.javaguides.dto.UserRegistrationDto;
import com.javaguides.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

    @Autowired
    private UserService userService;


    @ModelAttribute("users")
    public UserRegistrationDto registrationDto(){
        return new UserRegistrationDto();
    }

    /**
     * Load registration form string.
     *
     * @return the string
     */
    @GetMapping(value = "/loadRegistrationForm")
    public String loadRegistrationForm(){
        return "registration.html";
    }

    /**
     * Register user account string.
     *
     * @param registrationDto the registration dto
     * @return the string
     */

    @PostMapping(value = "/registerUser")
    public String registerUserAccount(@ModelAttribute("users")UserRegistrationDto registrationDto){
        userService.save(registrationDto);
        return "redirect:/registration/loadRegistrationForm?success";
    }
}
