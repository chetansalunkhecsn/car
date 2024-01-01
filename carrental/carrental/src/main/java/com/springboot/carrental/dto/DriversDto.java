package com.springboot.carrental.dto;

import lombok.Data;

@Data
public class DriversDto {

    private int id;

    private String driverImg;

    private String driverName;

    private String drivingExperiance;

    private long driverMobNo;

    private String availability;

    private String food;

    private String smoke;

    private String drink;

    private int charges;
}
