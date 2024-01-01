package com.springboot.carrental.dto;

import lombok.Data;



@Data
public class PaymentPayLoadDto {

    private Long cardNo;

    private String expDate;

    private int cvv;
}
