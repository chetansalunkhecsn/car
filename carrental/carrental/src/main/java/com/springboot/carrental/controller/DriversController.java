package com.springboot.carrental.controller;

import com.springboot.carrental.dto.CarDto;
import com.springboot.carrental.dto.DriversDto;
import com.springboot.carrental.entity.Drivers;
import com.springboot.carrental.services.DriversService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DriversController {

    @Autowired
    DriversService driversService;

    @PostMapping("/addDriver")
    public ResponseEntity<DriversDto> addDrivers(@RequestBody DriversDto driversDto){
     DriversDto addDriver = this.driversService.addDriver(driversDto);
     return new ResponseEntity<>(addDriver,HttpStatus.CREATED);
    }

    @GetMapping("/Drivers")
    public ResponseEntity<List<DriversDto>> getAllDrivers(){
        return ResponseEntity.ok((this.driversService.getAllDrivers()));
    }
}
