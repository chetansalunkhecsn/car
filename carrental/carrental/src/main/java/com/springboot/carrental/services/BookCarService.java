package com.springboot.carrental.services;

import com.springboot.carrental.dto.BookCarPayloadDto;
import com.springboot.carrental.dto.BookCarResponseDto;
import com.springboot.carrental.entity.BookCar;
import com.springboot.carrental.entity.Car;
import com.springboot.carrental.repository.BookCarRepo;
import com.springboot.carrental.repository.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

@Service
public class BookCarService {

    @Autowired
    BookCarRepo bookCarRepo;

    @Autowired
    CarRepo carRepo;

    public BookCarResponseDto bookCar(Long car_id , BookCarPayloadDto bookCarPayloadDto){
        int totalPrice = 0 ;
        int days;
    Car car = getCarFromDB(car_id);
        BookCar bookCar = new BookCar();
        bookCar.setCar(car);
        bookCar.setPickUpLocation(bookCarPayloadDto.getPickUpLocation());
        bookCar.setDropLocation(bookCarPayloadDto.getDropLocation());
        bookCar.setPickUpTime(bookCarPayloadDto.getPickUpTime());
        bookCar.setPickUpDate(bookCarPayloadDto.getPickUpDate());
        bookCar.setDropDate(bookCarPayloadDto.getDropDate());
        if (bookCarPayloadDto.getMembers() <= car.getPassangerCapacity()-1){
            bookCar.setMembers(bookCarPayloadDto.getMembers());
        }else {
            return null;
        }
        LocalDate date1 = bookCar.getPickUpDate();
        LocalDate date2 = bookCar.getDropDate();

        long day = ChronoUnit.DAYS.between(date1,date2);
        bookCar.setNumBags(bookCarPayloadDto.getNumBags());

        bookCarRepo.save(bookCar);


        BookCarResponseDto bookCarResponseDto = new BookCarResponseDto();
        bookCarResponseDto.setCarCompany(car.getCarCompany());
        bookCarResponseDto.setCarColor(car.getCarColor());
        bookCarResponseDto.setCarModel(car.getCarModel());
        bookCarResponseDto.setCarType(car.getCarType());
        bookCarResponseDto.setCarOwner(car.getCarOwner());
        bookCarResponseDto.setCarImg(car.getCarImg());
        bookCarResponseDto.setNumPlate(car.getNumPlate());
        bookCarResponseDto.setInsuranceValidity(car.getInsuranceValidity());
        bookCarResponseDto.setFuelType(car.getFuelType());
        bookCarResponseDto.setFeature(car.getFeature());
        bookCarResponseDto.setPickUpLocation(bookCar.getPickUpLocation());
        bookCarResponseDto.setDropLocation(bookCar.getDropLocation());
        bookCarResponseDto.setPickUpTime(bookCar.getPickUpTime());
        bookCarResponseDto.setPickUpDate(bookCar.getPickUpDate());
        bookCarResponseDto.setDropDate(bookCar.getDropDate());
        bookCarResponseDto.setPassangerCapacity(car.getPassangerCapacity());
        bookCarResponseDto.setMembers(bookCar.getMembers());
        bookCarResponseDto.setDays((int) day);
        bookCarResponseDto.setNumBags(bookCar.getNumBags());
       // bookCarResponseDto.setTotalPrice((int) (car.getCharge()*days));
        days = bookCarResponseDto.getDays();
        totalPrice =(days*car.getCharge());

        bookCarResponseDto.setTotalPrice(totalPrice);
        bookCarResponseDto.setId(bookCar.getId());

        return bookCarResponseDto;
    }

    private Car getCarFromDB(Long car_id) {
        Optional<Car> byId = carRepo.findById(car_id);
        return byId.orElse(null);


    }
}
