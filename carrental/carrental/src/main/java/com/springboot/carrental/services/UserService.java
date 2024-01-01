package com.springboot.carrental.services;

import com.springboot.carrental.dto.CarDto;
import com.springboot.carrental.dto.LoginDto;
import com.springboot.carrental.dto.UserDto;
import com.springboot.carrental.entity.Car;
import com.springboot.carrental.entity.User;
import com.springboot.carrental.repository.CarRepo;
import com.springboot.carrental.repository.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;


    @Autowired
    private ModelMapper modelMapper;

    public UserDto createUser(UserDto userDto) {
       User user = this.dtoToUser(userDto);
/*
        user.setAuth(auth);
*/
        User savedUser = this.userRepo.save(user);
        return this.userToDto(savedUser);
    }

    public User findByEmailAndPassword(String email, String password){
        return userRepo.findByEmailAndPassword(email, password);

    }



















//logic for user modelmapper
    private User dtoToUser(UserDto userDto) {
        User user = this.modelMapper.map(userDto, User.class);
        return user;
    }

    private UserDto userToDto(User user) {
        UserDto userDto = this.modelMapper.map(user, UserDto.class);
        return userDto;
    }



}








