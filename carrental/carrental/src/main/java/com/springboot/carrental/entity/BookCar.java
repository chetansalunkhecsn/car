package com.springboot.carrental.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Data
@Table(name = "book_car")
public class BookCar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String pickUpLocation;

    private String dropLocation;

    private String pickUpTime;

    private LocalDate pickUpDate;

    private LocalDate dropDate;

    private int passangerCapacity;

    private int members;

    private int days;

    private int numBags;

    @OneToOne
@JoinColumn(name = "Car_id")
 private Car car;

@OneToOne
@JoinColumn(name ="Driver_id" )
    private Drivers drivers;


}
//drivers