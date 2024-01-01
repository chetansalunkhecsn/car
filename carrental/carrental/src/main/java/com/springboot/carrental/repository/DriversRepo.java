package com.springboot.carrental.repository;

import com.springboot.carrental.entity.Drivers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface DriversRepo extends JpaRepository<Drivers,Integer> {
    Optional<Drivers> findById(Drivers driver_id);
}
