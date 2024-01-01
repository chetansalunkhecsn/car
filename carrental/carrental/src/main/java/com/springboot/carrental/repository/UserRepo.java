package com.springboot.carrental.repository;

import com.springboot.carrental.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {

    User findByEmailAndPassword(String email,String password);//custom method for fetching data from db

    Optional<User> findById(Long uId);
}
