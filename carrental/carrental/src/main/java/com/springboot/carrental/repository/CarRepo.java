package com.springboot.carrental.repository;

import com.springboot.carrental.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface CarRepo extends JpaRepository<Car,Long> {

}
//    default Optional<Car> findById(Long Car_id){
//          return findById(Car_id);
//     }