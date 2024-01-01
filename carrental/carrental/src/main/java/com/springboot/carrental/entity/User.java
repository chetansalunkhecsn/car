package com.springboot.carrental.entity;

import lombok.Data;


import javax.persistence.*;

@Entity
@Data
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private  String firstName;

    private  String lastName;

    private String dob;

    private String email;

    private String password;

//    private String auth;


  @OneToOne(mappedBy = "user",fetch = FetchType.LAZY)
  private Payment payment;
}
