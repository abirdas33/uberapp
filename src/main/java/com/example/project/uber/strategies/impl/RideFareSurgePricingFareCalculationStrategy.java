package com.example.project.uber.strategies.impl;

import com.example.project.uber.dto.RideRequestDto;
import com.example.project.uber.entities.RideRequest;
import com.example.project.uber.services.DistanceService;
import com.example.project.uber.strategies.RideFareCalculationStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RideFareSurgePricingFareCalculationStrategy implements RideFareCalculationStrategy {

    private  final DistanceService distanceService;
    private static final  double SURGE_FACTOR = 1;

    @Override
    public double calculateFare(RideRequest rideRequest) {
        double distance = distanceService.calculateDistance(rideRequest.getPickupLocation(),
                rideRequest.getDropLocation());
        return distance*RIDE_FARE_MULTIPLIER*SURGE_FACTOR;
    }
}
