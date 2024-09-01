package com.example.project.uber.strategies;

import com.example.project.uber.dto.RideRequestDto;
import com.example.project.uber.entities.Driver;
import com.example.project.uber.entities.RideRequest;

import java.util.List;

public interface DriverMatchingStrategy {

    List<Driver> findmatchingDrivers(RideRequest rideRequest);
}
