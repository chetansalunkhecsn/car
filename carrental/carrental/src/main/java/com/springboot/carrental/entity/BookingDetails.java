package com.springboot.carrental.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "Booking_Details")
public class BookingDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String fname;

    private String lname;

    private String driverImg;

    private String driverName;

    private Long driverMobNo;

    private int charges;

    private String hotel;

    private String room;

    private int stay;

    private String manageParking;

    private int finalCost;

    private String carCompany;

    private String carColor;

    private String carModel;

    private String carType;

    private String carImg;

    private String fuelType;

    private String pickUpLocation;

    private String dropLocation;

    private String pickUpTime;

    private LocalDate pickUpDate;

    private LocalDate dropDate;

    private int passangerCapacity;

    private int members;

    private int days;

    private Long cardNo;



}
