package com.example.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot.model.Passenger;

public interface PassengerRepo extends JpaRepository<Passenger, Integer> {

    List<Passenger> findByAddressOrSeatNumber(String address, String seatNumber);

}
