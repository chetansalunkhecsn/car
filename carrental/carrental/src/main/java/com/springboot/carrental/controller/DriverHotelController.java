package com.springboot.carrental.controller;

import com.springboot.carrental.dto.DriverHotelDto;
import com.springboot.carrental.entity.Drivers;
import com.springboot.carrental.services.DriverHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DriverHotelController {

    @Autowired
    DriverHotelService driverHotelService;

   /* @PostMapping("{driver_id}/driver-hotel")
    public ResponseEntity<DriverHotelDto> driverHotel(@PathVariable int driver_id , @RequestBody DriverHotelDto driverHotelDto){
        DriverHotelDto driverHotelDto1 = this.driverHotelService.driverHotel(driverHotelDto);
        return new ResponseEntity<>(driverHotelDto, HttpStatus.CREATED);
    }*/
       @PostMapping("{book}/{driver_id}/driver_hotel")
        public DriverHotelDto DriverHotel(@PathVariable int book,@PathVariable int driver_id,@RequestBody DriverHotelDto driverHotelDto){
           return driverHotelService.driverHotel(book,driver_id,driverHotelDto);
       }


}
