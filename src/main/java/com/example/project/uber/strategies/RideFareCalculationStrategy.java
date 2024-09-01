package com.example.project.uber.strategies;

import com.example.project.uber.dto.RideRequestDto;
import com.example.project.uber.entities.RideRequest;

public interface RideFareCalculationStrategy {

    double RIDE_FARE_MULTIPLIER = 10;
    double calculateFare(RideRequest rideRequest);
}
