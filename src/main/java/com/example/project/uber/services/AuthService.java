package com.example.project.uber.services;

import com.example.project.uber.dto.DriverDto;
import com.example.project.uber.dto.SignupDto;
import com.example.project.uber.dto.UserDto;

public interface AuthService {

    String login(String email, String password);

    UserDto signup(SignupDto signupDto);

    DriverDto onboardNewDriver(Long userid);
}
