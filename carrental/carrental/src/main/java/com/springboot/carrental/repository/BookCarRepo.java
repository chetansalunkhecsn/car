package com.springboot.carrental.repository;

import com.springboot.carrental.entity.BookCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookCarRepo extends JpaRepository<BookCar,Long> {
}
