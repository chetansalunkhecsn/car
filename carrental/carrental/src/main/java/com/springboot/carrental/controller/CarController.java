package com.springboot.carrental.controller;

import com.springboot.carrental.dto.CarDto;
import com.springboot.carrental.entity.Car;
import com.springboot.carrental.repository.CarRepo;
import com.springboot.carrental.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarController {

    @Autowired
    CarRepo carRepo;

    @Autowired
    CarService carService;

    @PostMapping("/addCar")
    public ResponseEntity<CarDto> addNewCar(@RequestBody CarDto carDto){
        CarDto AddedCar = this.carService.addCar(carDto);
        return new ResponseEntity<>(AddedCar, HttpStatus.CREATED);
    }
    @GetMapping("/allCars")
    public ResponseEntity<List<CarDto>> getAllCars(){

        return ResponseEntity.ok((this.carService.getAllCars()));
    }

    @GetMapping("/book-car/{id}")
    public  ResponseEntity<CarDto> getCarById(@PathVariable long id){
        return ResponseEntity.ok((this.carService.getCarById(id)));
    }


}
