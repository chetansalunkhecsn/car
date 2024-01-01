package com.springboot.carrental.controller;

import com.springboot.carrental.dto.PaymentPayLoadDto;
import com.springboot.carrental.dto.PaymentResponseDto;
import com.springboot.carrental.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    @Autowired
    PaymentService paymentService;


    @PostMapping("{uId}/{dId}/finalConfirm")
    public PaymentResponseDto makePayment(@PathVariable Long uId , @PathVariable int dId, @RequestBody PaymentPayLoadDto paymentPayLoadDto){
        return  paymentService.makePayment(uId, dId,paymentPayLoadDto);

    }

}
