package com.example.project.uber.services.impl;

import com.example.project.uber.dto.DriverDto;
import com.example.project.uber.dto.RideDto;
import com.example.project.uber.dto.RideRequestDto;
import com.example.project.uber.dto.RiderDto;
import com.example.project.uber.entities.Driver;
import com.example.project.uber.entities.Ride;
import com.example.project.uber.entities.enums.RideStatus;
import com.example.project.uber.services.RideService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RideServiceImpl implements RideService {

    @Override
    public Ride getRideById(Long rideId) {
        return null;
    }

    @Override
    public void matchWithDrivers(RideRequestDto rideRequestDto) {

    }

    @Override
    public Ride createNewRide(RideRequestDto rideRequestDto, Driver driver) {
        return null;
    }

    @Override
    public Ride updateRideStatus(Long rideId, RideStatus rideStatus) {
        return null;
    }

    @Override
    public Page<Ride> getAllRidesOfRider(Long riderId, PageRequest pageRequest) {
        return null;
    }

    @Override
    public Page<Ride> getAllRidesOfDriver(Long driverId, PageRequest pageRequest) {
        return null;
    }
}
