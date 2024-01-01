package com.springboot.carrental.services;

import com.springboot.carrental.dto.DriverHotelDto;
import com.springboot.carrental.entity.BookCar;
import com.springboot.carrental.entity.DriverHotel;
import com.springboot.carrental.entity.Drivers;
import com.springboot.carrental.repository.BookCarRepo;
import com.springboot.carrental.repository.DriverHotelRepo;
import com.springboot.carrental.repository.DriversRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DriverHotelService {

    @Autowired
    DriversRepo driversRepo;

    @Autowired
    DriverHotelRepo driverHotelRepo;

    @Autowired
    BookCarRepo bookCarRepo;

    @Autowired
    ModelMapper modelMapper;

    public DriverHotelDto driverHotelToDriverHotelDto(DriverHotel driverHotel){
        DriverHotelDto driverHotelDto = this.modelMapper.map(driverHotel,DriverHotelDto.class);
        return driverHotelDto;
    }
    public DriverHotel driverHotelDtoToDriverHotel(DriverHotelDto driverHotelDto){
    DriverHotel driverHotel = this.modelMapper.map(driverHotelDto,DriverHotel.class);
    return driverHotel;
    }

    public DriverHotelDto driverHotel(int book,int driver_id, DriverHotelDto driverHotelDto){
        Drivers drivers = getDriverFromDb(driver_id);
        BookCar bookCar = getBookFromDb(book);
        bookCar.setDrivers(drivers);
        DriverHotel driverHotel = this.driverHotelDtoToDriverHotel(driverHotelDto);
        driverHotel.setDrivers(drivers);
        DriverHotel savedDriverHotel = this.driverHotelRepo.save(driverHotel);
        return this.driverHotelToDriverHotelDto(savedDriverHotel);
    }

    private BookCar getBookFromDb(int book) {
        Optional<BookCar> byId = bookCarRepo.findById((long) book);
        return byId.orElse(null);
    }

    private Drivers getDriverFromDb(int driver_id){
        Optional<Drivers> byId = driversRepo.findById(driver_id);
        return  byId.orElse(null);
    }
}
