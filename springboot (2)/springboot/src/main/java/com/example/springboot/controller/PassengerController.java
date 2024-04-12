package com.example.springboot.controller;

import com.example.springboot.model.Passenger;
import com.example.springboot.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
// @RequestMapping("/api/passengers")
public class PassengerController {

    @Autowired
    private PassengerService passengerService;

    @PostMapping("/postp")
    public ResponseEntity<Passenger> addPassenger(@RequestBody Passenger passenger) {
        Passenger createdPassenger = passengerService.create(passenger);
        return new ResponseEntity<>(createdPassenger, HttpStatus.CREATED);
    }
    
    @GetMapping("/getp")
    public ResponseEntity<List<Passenger>> getUserData() {
        return new ResponseEntity<>(passengerService.getAllDetails(), HttpStatus.OK);
    }
    
    @GetMapping("/api/{offset}/{pagesize}/{field}")
    public List<Passenger> getsorting(@PathVariable int offset,@PathVariable int pagesize,@PathVariable String field)
    {
        return passengerService.getsort(offset,pagesize,field);
    }
    @GetMapping("/api/sortBy/{field}")
    public List<Passenger> g(@PathVariable String field)
    {
        return passengerService.sort(field);
    }
    @GetMapping("/select/query/{address}/{seatNumber}")
    public List<Passenger>displayall(@PathVariable String address,@PathVariable String seatNumber)
    {
        return passengerService.getdetails(address,seatNumber);
    }


    @PutMapping("/putp/{passengerId}")
    public ResponseEntity<Passenger> updatePassenger(
            @PathVariable int passengerId,
            @RequestBody Passenger passenger
    ) {
        boolean updated = passengerService.updateDetails(passengerId, passenger);
        if (updated) {
            return new ResponseEntity<>(passenger, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delp/{passengerId}")
    public ResponseEntity<Boolean> deletePassenger(@PathVariable int passengerId) {
        boolean deleted = passengerService.deletePassenger(passengerId);
        if (deleted) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }
}

