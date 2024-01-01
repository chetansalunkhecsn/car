package com.springboot.carrental.services;

import com.springboot.carrental.dto.PaymentPayLoadDto;
import com.springboot.carrental.dto.PaymentResponseDto;
import com.springboot.carrental.entity.*;
import com.springboot.carrental.repository.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

    @Autowired
    DriversRepo driversRepo;

    @Autowired
    BookingDetailsRepo bookingDetailsRepo;

    @Autowired
    UserRepo userRepo;

    @Autowired
    PaymentRepo paymentRepo;

    @Autowired
    ModelMapper modelMapper;

    public PaymentResponseDto makePayment(Long uId , int dId, PaymentPayLoadDto paymentPayLoadDto){
     User user = getUserFromDb(uId);
        Drivers drivers = getDriverFromDb(dId);

        Payment payment = new Payment();
        payment.setUser(user);
        payment.setDrivers(drivers);
        payment.setCardNo(paymentPayLoadDto.getCardNo());
        payment.setExpDate(paymentPayLoadDto.getExpDate());
        payment.setCvv(paymentPayLoadDto.getCvv());

        paymentRepo.save(payment);

        PaymentResponseDto responseDto = new PaymentResponseDto();

        responseDto.setId(payment.getId());
        responseDto.setEmail(user.getEmail());
        responseDto.setFname(user.getFirstName());
        responseDto.setLname(user.getLastName());
        responseDto.setDriverImg(drivers.getDriverImg());
        responseDto.setDriverName(drivers.getDriverName());
        responseDto.setDriverMobNo(drivers.getDriverMobNo());
        responseDto.setCharges(drivers.getCharges());
        responseDto.setHotel(drivers.getDriverHotel().getHotel());
        responseDto.setRoom(drivers.getDriverHotel().getRoom());
        responseDto.setStay(drivers.getDriverHotel().getStay());
        responseDto.setManageParking(drivers.getDriverHotel().getManageParking());
        responseDto.setFinalCost(drivers.getDriverHotel().getFinalCost());
        responseDto.setCarCompany(drivers.getBookCar().getCar().getCarCompany());
        responseDto.setCarColor(drivers.getBookCar().getCar().getCarColor());
        responseDto.setCarModel(drivers.getBookCar().getCar().getCarModel());
        responseDto.setCarType(drivers.getBookCar().getCar().getCarType());
        responseDto.setCarImg(drivers.getBookCar().getCar().getCarImg());
        responseDto.setFuelType(drivers.getBookCar().getCar().getFuelType());
        responseDto.setPickUpLocation(drivers.getBookCar().getPickUpLocation());
        responseDto.setDropLocation(drivers.getBookCar().getDropLocation());
        responseDto.setPickUpTime(drivers.getBookCar().getPickUpTime());
        responseDto.setPickUpDate(drivers.getBookCar().getPickUpDate());
        responseDto.setDropDate(drivers.getBookCar().getDropDate());
        responseDto.setPassangerCapacity(drivers.getBookCar().getPassangerCapacity());
        responseDto.setMembers(drivers.getBookCar().getMembers());
        responseDto.setDays(drivers.getBookCar().getDays());
        responseDto.setCardNo(paymentPayLoadDto.getCardNo());



        BookingDetails details = modelMapper.map(responseDto, BookingDetails.class);
        bookingDetailsRepo.save(details);


        return responseDto;
    }

    private User getUserFromDb(Long uId) {
        Optional<User> user = userRepo.findById(uId);
        return user.orElse(null);
    }
    private Drivers getDriverFromDb(int dId){
        Optional<Drivers> drivers = driversRepo.findById(dId);
        return drivers.orElse(null);
    }

}
