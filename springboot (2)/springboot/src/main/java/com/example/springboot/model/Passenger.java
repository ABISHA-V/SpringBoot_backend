package com.example.springboot.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Passenger {

    @Id
    private int passengerId;
    private String passengerName;
    private String password;
    private String mobileNumber;
    private int age;
    private String address;
    private String busType;
    private String seatNumber;

    public Passenger(int passengerId, String passengerName, String password, String mobileNumber, int age, String address, String busType, String seatNumber) {
        this.passengerId = passengerId;
        this.passengerName = passengerName;
        this.password = password;
        this.mobileNumber = mobileNumber;
        this.age = age;
        this.address = address;
        this.busType = busType;
        this.seatNumber = seatNumber;
    }

    public Passenger() {
    }

    public int getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(int passengerId) {
        this.passengerId = passengerId;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBusType() {
        return busType;
    }

    public void setBusType(String busType) {
        this.busType = busType;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }
 
    @OneToOne(mappedBy = "passenger", cascade = CascadeType.ALL ,fetch=FetchType.LAZY)
    @JoinColumn(name = "passengerId")
    @JsonManagedReference
    private User user;
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    } 

}
