package com.springboot.carrental.dto;

import lombok.Data;

import java.time.LocalDate;
@Data
public class BookCarResponseDto {

        private Long id;

        private String carCompany;

        private String carColor;

        private String carModel;

        private String carType;

        private String carOwner;

        private String carImg;

        private String numPlate;

        private String insuranceValidity;

        private String fuelType;

        private String feature;

        private String pickUpLocation;

        private String dropLocation;

        private String pickUpTime;

        private LocalDate pickUpDate;

        private LocalDate dropDate;

        private int passangerCapacity;

        private int members;

        private int days;

        private int numBags;

        private double totalPrice;


}