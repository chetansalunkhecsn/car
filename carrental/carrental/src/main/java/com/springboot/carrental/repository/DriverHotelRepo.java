package com.springboot.carrental.repository;

import com.springboot.carrental.entity.DriverHotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverHotelRepo extends JpaRepository<DriverHotel,Integer> {
}
