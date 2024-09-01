package com.example.project.uber.services.impl;

import com.example.project.uber.dto.DriverDto;
import com.example.project.uber.dto.SignupDto;
import com.example.project.uber.dto.UserDto;
import com.example.project.uber.entities.Rider;
import com.example.project.uber.entities.User;
import com.example.project.uber.entities.enums.Role;
import com.example.project.uber.exceptions.RuntimeConflictException;
import com.example.project.uber.repositories.UserRepository;
import com.example.project.uber.services.AuthService;
import com.example.project.uber.services.RiderService;
import lombok.RequiredArgsConstructor;
import org.aspectj.asm.IModelFilter;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final ModelMapper mapper;
    private final UserRepository userRepository;
    private final RiderService riderService;

    @Override
    public String login(String email, String password) {
        return "";
    }

    @Override
    @Transactional
    public UserDto signup(SignupDto signupDto) {

        User user = userRepository.findByEmail(signupDto.getEmail()).orElse(null);
        if(user != null) {
            new RuntimeConflictException("Cannot signup, User already exists with email " + signupDto.getEmail());
        }

        User mappeduser = mapper.map(signupDto,User.class);
        mappeduser.setRoles(Set.of(Role.RIDER));
        User savedUser = userRepository.save(mappeduser);

        riderService.createNewRider(savedUser);

        return mapper.map(savedUser,UserDto.class);
    }

    @Override
    public DriverDto onboardNewDriver(Long userid) {
        return null;
    }
}
