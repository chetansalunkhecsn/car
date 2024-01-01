package com.springboot.carrental.services;

import com.springboot.carrental.dto.BookingDetailsDto;
import com.springboot.carrental.entity.BookingDetails;
import com.springboot.carrental.repository.BookingDetailsRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingDetailService {

    @Autowired
    BookingDetailsRepo bookingDetailsRepo;

    @Autowired
    ModelMapper modelMapper;


    public BookingDetailsDto findByEmail(String email){
        BookingDetails byMail = bookingDetailsRepo.findByEmail(email);
       return modelMapper.map(byMail, BookingDetailsDto.class);
    }
}
