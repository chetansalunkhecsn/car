package com.springboot.carrental.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Payment_Details")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long cardNo;

    private String expDate;

    private int cvv;

    //{"cardNo":"","expDate":"","cvv":""}

    @OneToOne
    @JoinColumn(name = "Drivers")
    private Drivers drivers;


   @OneToOne
   @JoinColumn(name = "Users")
    private User user;
}
