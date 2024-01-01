package com.springboot.carrental.dto;

import lombok.Data;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import javax.validation.constraints.Size;


@Data
public class UserDto {

    private Long id ;

    @NotEmpty
    @Size(min = 4,message = "username must be min 4 characters")
    private String firstName ;


    @NotEmpty
    @Size(min = 4,message = "username must be min 4 characters")
    private String lastName;

    private String dob;

    @Email(message = "email address is not valid")
    private String email ;

    @NotEmpty
    @Size(min = 8,max = 12,message = "password must be min 8 char and max 12")
    private String password ;


}
