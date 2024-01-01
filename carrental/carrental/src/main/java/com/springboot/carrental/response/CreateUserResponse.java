package com.springboot.carrental.response;

import com.springboot.carrental.dto.UserDto;
import lombok.Data;

@Data
public class CreateUserResponse {
    private UserDto user;
    private String auth;

    public CreateUserResponse(UserDto user, String auth) {
        this.user = user;
        this.auth = auth;


    }
}
