package com.example.project.uber.dto;

import com.example.project.uber.entities.Rider;
import com.example.project.uber.entities.enums.PaymentMethod;
import com.example.project.uber.entities.enums.RideRequestStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.locationtech.jts.geom.Point;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RideRequestDto {

    private Long id;

    private PointDTO pickupLocation;
    private PointDTO dropLocation;
    private LocalDateTime requestedTime;
    private RiderDto rider;
    private Double fare;
    private PaymentMethod paymentMethod;
    private RideRequestStatus rideRequestStatus;

}
