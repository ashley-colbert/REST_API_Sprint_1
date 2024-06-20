package com.keyin.citiesInfo;

import com.keyin.airportInfo.Airports;

import java.util.ArrayList;

public class Cities {
    private String id;
    private String name;
    private String state;
    private int population;
    private ArrayList<Airports> airports;

    public Cities(String id, String name, String state, int population, ArrayList<Airports> airports) {
        this.id = id;
        this.name = name;
        this.state = state;
        this.population = population;
        this.airports = airports;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public ArrayList<Airports> getAirports() {
        return airports;
    }

    public void setAirports(ArrayList<Airports> airports) {
        this.airports = airports;
    }
}
