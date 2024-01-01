package com.springboot.carrental.services;

import com.springboot.carrental.dto.DriversDto;
import com.springboot.carrental.entity.BookCar;
import com.springboot.carrental.entity.Car;
import com.springboot.carrental.entity.Drivers;
import com.springboot.carrental.repository.DriversRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DriversService {




    @Autowired
    DriversRepo driversRepo;

    @Autowired
    ModelMapper modelMapper;


    private Drivers driversDtoToDrivers(DriversDto driversDto){
        Drivers drivers = this.modelMapper.map(driversDto,Drivers.class);
        return drivers;

        //private Payment paymentDtoToPayment(PaymentDto paymentDto){
        //Payment payment = this.modelmapper.map(paymentDto,Payment.class)
        // return payment;
    }

    private DriversDto driversToDriversDto(Drivers drivers){
        DriversDto driversDto = this.modelMapper.map(drivers,DriversDto.class);
        return  driversDto;
    }

    public DriversDto addDriver( DriversDto driversDto){
        Drivers drivers = this.driversDtoToDrivers(driversDto);
        Drivers savedDrivers = this.driversRepo.save(drivers);
        return this.driversToDriversDto(savedDrivers);
    }

    public List<DriversDto> getAllDrivers(){
        List<Drivers> drivers = this.driversRepo.findAll();
        List<DriversDto> driversDtos = drivers.stream().map(driver -> this.driversToDriversDto(driver)).collect(Collectors.toList());
        return driversDtos;
    }


}