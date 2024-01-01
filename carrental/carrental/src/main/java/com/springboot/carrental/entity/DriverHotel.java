package com.springboot.carrental.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Driver_Hotel")
public class DriverHotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String hotel;

    private String room;

    private int stay;

    private String manageParking;

    private int finalCost;


    @OneToOne
    @JoinColumn(name = "driver_id")
    private Drivers drivers;
}
