package com.springboot.carrental.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "Drivers")
public class Drivers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
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


    @OneToOne(mappedBy = "drivers",fetch = FetchType.LAZY)
    private BookCar bookCar;

    @OneToOne(mappedBy = "drivers", fetch = FetchType.LAZY)
    private DriverHotel driverHotel ;

    @OneToOne(mappedBy = "drivers",fetch = FetchType.LAZY)
    private Payment payment;


    }

//bookcar