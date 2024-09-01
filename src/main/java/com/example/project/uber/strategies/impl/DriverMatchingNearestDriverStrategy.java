package com.example.project.uber.strategies.impl;

import com.example.project.uber.dto.RideRequestDto;
import com.example.project.uber.entities.Driver;
import com.example.project.uber.entities.RideRequest;
import com.example.project.uber.repositories.DriverRepository;
import com.example.project.uber.strategies.DriverMatchingStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DriverMatchingNearestDriverStrategy implements DriverMatchingStrategy {

    private final DriverRepository driverRepository;

    @Override
    public List<Driver> findmatchingDrivers(RideRequest rideRequest) {
        return driverRepository.findTenNearestDrivers(rideRequest.getPickupLocation());
    }
}
