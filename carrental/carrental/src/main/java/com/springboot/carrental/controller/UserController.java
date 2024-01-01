package com.springboot.carrental.controller;

import com.springboot.carrental.dto.LoginDto;
import com.springboot.carrental.dto.UserDto;
import com.springboot.carrental.entity.User;
import com.springboot.carrental.response.CreateUserResponse;
import com.springboot.carrental.services.UserService;
import com.springboot.carrental.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register( @Valid @RequestBody UserDto userDto) {
        // Check if the user already exists
        if (userService.findByEmailAndPassword(userDto.getEmail(),userDto.getPassword()) != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        String auth = JwtUtil.generateToken(userDto.getEmail());
        UserDto createdUserDto = this.userService.createUser(userDto);
        CreateUserResponse response = new CreateUserResponse(createdUserDto, auth);

        return ResponseEntity.ok(response);
    }



    @PostMapping("/login")
   public ResponseEntity<UserDto> login(@Valid @RequestBody LoginDto loginDto){
        User login =this.userService.findByEmailAndPassword(loginDto.getEmail(),loginDto.getPassword());
        return new ResponseEntity(login,HttpStatus.CREATED);

    }


}
