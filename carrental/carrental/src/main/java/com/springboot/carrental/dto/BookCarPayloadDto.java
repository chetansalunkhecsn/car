package com.springboot.carrental.dto;

import lombok.Data;

import java.time.LocalDate;
@Data
public class BookCarPayloadDto {
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

}
