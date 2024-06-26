package com.keyin.passengerInfo;

import com.keyin.aircraftInfo.Aircraft;
import com.keyin.airportInfo.Airports;

import java.util.ArrayList;

public class Passengers {
    private String id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private ArrayList<Aircraft> aircraft;
    private ArrayList<Airports> airports;

    public Passengers(String id, String firstName, String lastName, String phoneNumber, ArrayList<Aircraft> aircraft) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.aircraft = aircraft;
        this.airports = airports;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public ArrayList<Aircraft> getAircraft() {
        return aircraft;
    }

    public void setAircraft(ArrayList<Aircraft> aircraft) {
        this.aircraft = aircraft;
    }

    public ArrayList<Airports> getAirports() {
        return airports;
    }

    public void setAirports(ArrayList<Airports> airports) {
        this.airports = airports;
    }
}
