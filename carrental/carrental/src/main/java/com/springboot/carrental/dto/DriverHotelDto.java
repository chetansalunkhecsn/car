package com.springboot.carrental.dto;

import lombok.Data;

@Data
public class DriverHotelDto {
    private int id;

    private String hotel;

    private String room;

    private int stay;

    private String manageParking;

    private int finalCost;

}
