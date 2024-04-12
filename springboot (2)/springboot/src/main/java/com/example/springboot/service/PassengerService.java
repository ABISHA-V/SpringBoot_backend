package com.example.springboot.service;

import com.example.springboot.model.Passenger;
import com.example.springboot.repository.PassengerRepo;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerService {

    @Autowired
    private PassengerRepo passengerRepo;

    public Passenger create(Passenger passenger) {
        return passengerRepo.save(passenger);
    }

    public List<Passenger> getAllDetails() {
        return passengerRepo.findAll();
    }

    public Passenger getPassengerById(int id) {
        return passengerRepo.findById(id).orElse(null);
    }

    public List<Passenger> getsort(int pageNumber, int pageSize, String field) {
        return passengerRepo.findAll(PageRequest.of(pageNumber, pageSize)
                .withSort(Sort.by(Sort.Direction.ASC, field))).getContent();
    }

    public List<Passenger> sort(String field) {
        Sort sort = Sort.by(Sort.Direction.ASC, field);
        return passengerRepo.findAll(sort);
    }
    public List<Passenger> getdetails(String address,String seatNumber)
    {
        return passengerRepo.findByAddressOrSeatNumber(address,seatNumber);
    }

    public boolean updateDetails(int id, Passenger passenger) {
        if (!passengerRepo.existsById(id)) {
            return false;
        }
        passenger.setPassengerId(id); // Ensure the passenger object has the correct ID
        passengerRepo.save(passenger);
        return true;
    }

    public boolean deletePassenger(int id) {
        if (!passengerRepo.existsById(id)) {
            return false;
        }
        passengerRepo.deleteById(id);
        return true;
    }
}
