package com.example.project.uber.services.impl;

import com.example.project.uber.dto.DriverDto;
import com.example.project.uber.dto.RideDto;
import com.example.project.uber.dto.RideRequestDto;
import com.example.project.uber.dto.RiderDto;
import com.example.project.uber.entities.Driver;
import com.example.project.uber.entities.RideRequest;
import com.example.project.uber.entities.Rider;
import com.example.project.uber.entities.User;
import com.example.project.uber.entities.enums.RideRequestStatus;
import com.example.project.uber.exceptions.ResourceNotFoundException;
import com.example.project.uber.repositories.RideRequestRepository;
import com.example.project.uber.repositories.RiderRepository;
import com.example.project.uber.services.RiderService;
import com.example.project.uber.strategies.DriverMatchingStrategy;
import com.example.project.uber.strategies.RideFareCalculationStrategy;
import com.example.project.uber.strategies.RideStrategyManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class RiderServiceImpl implements RiderService {
    private final ModelMapper modelMapper;
    private final RideRequestRepository rideRequestRepository;
    private final RiderRepository riderRepository;
    private final RideStrategyManager rideStrategyManager;

    @Override
    @Transactional
    public RideRequestDto requestRide(RideRequestDto rideRequestDto) {
        Rider rider = getCurrentRider();
        RideRequest rideRequest = modelMapper.map(rideRequestDto,RideRequest.class);
        rideRequest.setRideRequestStatus(RideRequestStatus.PENDING);
        rideRequest.setRider(rider);


        Double fare = rideStrategyManager.rideFareCalculationStrategy().calculateFare(rideRequest);
        rideRequest.setFare(fare);
        System.out.println(rideRequest.getId());
        RideRequest saveRideRequest = rideRequestRepository.save(rideRequest);

        List<Driver> drivers = rideStrategyManager.driverMatchingStrategy(rider.getRating()).findmatchingDrivers(rideRequest);

        return modelMapper.map(saveRideRequest,RideRequestDto.class);
    }

    @Override
    public RideDto cancelRide(Long rideId) {
        return null;
    }

    @Override
    public DriverDto rateDriver(Long rideId, Integer rating) {
        return null;
    }

    @Override
    public RiderDto getMyProfile() {
        return null;
    }

    @Override
    public List<RideDto> getAllMyRides() {
        return List.of();
    }

    @Override
    public Rider createNewRider(User user) {
        Rider rider = Rider
                .builder()
                .user(user)
                .rating(0.0)
                .build();

        return riderRepository.save(rider);
    }

    @Override
    public Rider getCurrentRider() {
        return riderRepository.findById(1L).orElseThrow(() -> new ResourceNotFoundException(
                "Rider not found with id: "+ 1
        ));
    }


}
