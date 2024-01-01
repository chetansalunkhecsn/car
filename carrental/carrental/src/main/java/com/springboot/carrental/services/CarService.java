package com.springboot.carrental.services;

import com.springboot.carrental.dto.CarDto;
import com.springboot.carrental.entity.Car;
import com.springboot.carrental.entity.User;
import com.springboot.carrental.repository.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarService {

    @Autowired
    CarRepo carRepo;

    @Autowired
    private ModelMapper modelMapper;


    //add car and save
    public CarDto addCar(CarDto carDto){
        Car car = this.dtoToCar(carDto);
        Car savedCar = this.carRepo.save(car);
        return this.carToDto(savedCar);
    }
    public List<CarDto> getAllCars(){
        List<Car> cars = this.carRepo.findAll();

        List<CarDto> carDtos = cars.stream().map(car -> this.carToDto(car)).collect(Collectors.toList());

        return  carDtos;

    }

   public CarDto getCarById(long id){

        Car car =this.carRepo.findById(id).get();
        return this.carToDto(car);

    }

    // @Override
    //    public UserDto getUserById(Integer userId) {
    //
    //        User user = this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("user", "id", userId));
    //
    //        return this.userToDto(user);
    ////public User findByEmailAndPassword(String email, String password){
    //       // return userRepo.findByEmailAndPassword(email, password);





















    //logic for car modelmapper
    private Car dtoToCar(CarDto carDto){
        Car car = this.modelMapper.map(carDto,Car.class);
        return car;
    }

    private CarDto carToDto(Car car){
        CarDto carDto = this.modelMapper.map(car,CarDto.class);
        return carDto;
    }
}
