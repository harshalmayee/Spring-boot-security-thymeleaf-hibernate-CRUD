package com.javaguides.service.impl;

import com.javaguides.constants.ROLE;
import com.javaguides.dto.UserRegistrationDto;
import com.javaguides.model.Role;
import com.javaguides.model.User;
import com.javaguides.repository.UserRepository;
import com.javaguides.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {


    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public User save(UserRegistrationDto registrationDto) {
        User user=new User(registrationDto.getFirstName(), registrationDto.getLastName(),
                           registrationDto.getEmailId(), passwordEncoder.encode(registrationDto.getPassword()),
                           Arrays.asList(new Role(String.valueOf(ROLE.ROLE_ADMIN))));
        return userRepository.save(user);
    }


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user=userRepository.findByEmailId(s);
        if(user==null){throw new UsernameNotFoundException("Invalid username or password...");}
        return new org.springframework.security.core.userdetails.User(user.getEmailId(),user.getPassword(),mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}
