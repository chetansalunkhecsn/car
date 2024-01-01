package com.springboot.carrental.dto;

import lombok.Data;

import java.time.LocalDate;
@Data
public class BookingDetailsDto {
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
