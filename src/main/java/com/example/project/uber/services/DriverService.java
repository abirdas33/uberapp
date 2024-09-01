package com.example.project.uber.services;

import com.example.project.uber.dto.DriverDto;
import com.example.project.uber.dto.RideDto;
import com.example.project.uber.dto.RiderDto;

import java.util.List;

public interface DriverService {

    RideDto acceptRide(Long rideId);
    RideDto cancelRide(Long rideId);
    RideDto startRide(Long rideId);
    RideDto endRide(Long rideId);
    RiderDto rateRider(Long rideId,Integer rating);
    DriverDto getMyProfile();
    List<RideDto> getAllMyRides();

}
