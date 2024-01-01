package com.springboot.carrental.entity;


import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "Cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "car_company")
    private String carCompany;

    @Column(name = "car_color")
    private String carColor;

    @Column(name = "car_model")
    private String carModel;

    @Column(name = "car_type")
    private String carType;

    @Column(name = "car_img")
    private String carImg;

    @Column(name = "car_360")
    private String car360;

    @Column(name = "car_owner")
    private String carOwner;

    @Column(name = "num_plate")
    private String numPlate;

    @Column(name = "reg_date")
    private String regDate;

    @Column(name = "insurance")
    private String insurance;

    @Column(name = "insurance_validity")
    private String insuranceValidity;

    @Column(name = "passenger_capacity")
    private int passangerCapacity;

    @Column(name = "fuel_type")
    private String fuelType;

    @Column(name = "feature")
    private String feature;

    @Column(name = "total_running")
    private int totalRunning;

    @Column(name = "__v")
    private int __v;

    @Column(name = "charge")
    private int charge;

    @OneToOne(mappedBy = "car",fetch = FetchType.LAZY)
    private BookCar bookCar;
}