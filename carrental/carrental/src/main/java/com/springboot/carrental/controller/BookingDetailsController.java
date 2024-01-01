package com.springboot.carrental.controller;

import com.springboot.carrental.dto.BookingDetailsDto;
import com.springboot.carrental.services.BookingDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingDetailsController {

    @Autowired
    BookingDetailService bookingDetailService;

    @GetMapping("Ticket_Details/{email}")
    public BookingDetailsDto ticketDetails(@PathVariable String email){
        return bookingDetailService.findByEmail(email);
    }


}
