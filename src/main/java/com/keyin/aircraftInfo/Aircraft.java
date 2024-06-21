package com.keyin.aircraftInfo;

import com.keyin.airportInfo.Airports;

import java.util.ArrayList;

public class Aircraft {
    private String id;
    private String type;
    private String airlineName;
    private int numberOfPassengers;
    private ArrayList<Airports> airportsTakeOff;
    private ArrayList<Airports> airportsLand;


    public Aircraft(String id, String type, String airlineName, int numberOfPassengers, ArrayList<Airports> airports) {
        this.id = id;
        this.type = type;
        this.airlineName = airlineName;
        this.numberOfPassengers = numberOfPassengers;
        this.airportsTakeOff = airportsTakeOff;
        this.airportsLand = airportsLand;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    public ArrayList<Airports> getAirportsLand() {
        return airportsLand;
    }

    public void setAirportsLand(ArrayList<Airports> airportsLand) {
        this.airportsLand = airportsLand;
    }

    public ArrayList<Airports> getAirportsTakeOff() {
        return airportsTakeOff;
    }

    public void setAirportsTakeOff(ArrayList<Airports> airportsTakeOff) {
        this.airportsTakeOff = airportsTakeOff;
    }
}
