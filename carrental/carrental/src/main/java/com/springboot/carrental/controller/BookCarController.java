package com.springboot.carrental.controller;

import com.springboot.carrental.dto.BookCarPayloadDto;
import com.springboot.carrental.dto.BookCarResponseDto;
import com.springboot.carrental.services.BookCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookCarController {

    @Autowired
    BookCarService bookCarService;

    @PostMapping("/book-now/{car_id}")
    public BookCarResponseDto bookNow(@RequestBody BookCarPayloadDto bookCarPayloadDto, @PathVariable Long car_id){
        return bookCarService.bookCar(car_id,bookCarPayloadDto);
    }
}
//controller for car/with name