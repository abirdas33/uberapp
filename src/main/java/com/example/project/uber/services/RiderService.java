package com.example.project.uber.services;

import com.example.project.uber.dto.DriverDto;
import com.example.project.uber.dto.RideDto;
import com.example.project.uber.dto.RideRequestDto;
import com.example.project.uber.dto.RiderDto;
import com.example.project.uber.entities.Rider;
import com.example.project.uber.entities.User;

import java.util.List;

public interface RiderService {
    RideRequestDto requestRide(RideRequestDto rideRequestDto);
    RideDto cancelRide(Long rideId);


    DriverDto rateDriver(Long rideId, Integer rating);
    RiderDto getMyProfile();
    List<RideDto> getAllMyRides();
    Rider createNewRider(User user);

    Rider getCurrentRider();
}
