package com.example.project.uber.dto;

import com.example.project.uber.entities.Driver;
import com.example.project.uber.entities.Rider;
import com.example.project.uber.entities.enums.PaymentMethod;
import com.example.project.uber.entities.enums.RideStatus;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.locationtech.jts.geom.Point;

import java.time.LocalDateTime;

public class RideDto {

    private Long id;
    private Point pickupLocation;
    private Point dropLocation;
    private LocalDateTime createdTime;
    private RiderDto rider;
    private DriverDto driver;
    private PaymentMethod paymentMethod;
    private RideStatus rideStatus;
    private String otp;
    private Double Fare;
    private LocalDateTime startedAt;
    private LocalDateTime endedAt;

}
