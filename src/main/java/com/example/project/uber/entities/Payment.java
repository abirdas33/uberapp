package com.example.project.uber.entities;

import com.example.project.uber.entities.enums.PaymentMethod;
import com.example.project.uber.entities.enums.PaymentStatus;
import com.example.project.uber.entities.enums.RideRequestStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.locationtech.jts.geom.Point;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

   @OneToOne(fetch = FetchType.LAZY)
    private Ride ride;

   private Double amount;

   @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;

   @CreationTimestamp
   private LocalDateTime paymentTime;
}
