package com.keyin.airportInfo;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AirportService {
    private Map<Integer, Airports> airportMap = new HashMap<Integer, Airports>();

    public void setAirportMap(Map<Integer, Airports> airportMap) {
        this.airportMap = airportMap;
    }

    public Airports getAirport(Integer index) {
        return airportMap.get(index);
    }

    public Airports createAirport(Airports newAirport) {
        airportMap.put(airportMap.size() +1, newAirport);
        return newAirport;
    }

    public List<Airports> getAllAirports() {
        return List.copyOf(airportMap.values());
    }

    public Airports updateAirport(Integer index, Airports updatedAirport) {
        Airports airportToUpdate = airportMap.get(index);

        airportToUpdate.setId(updatedAirport.getId());
        airportToUpdate.setName(updatedAirport.getName());
        airportToUpdate.setCode(updatedAirport.getCode());

        airportMap.put(index, airportToUpdate);
        return airportToUpdate;
    }

    public void deleteAirport(Integer index) {
        airportMap.remove(index);
    }

    public List<Airports> findAirportByIdNameCode(String id, String name, String code) {
        List<Airports> airportsFound = new ArrayList<Airports>();

        for (Airports airports : airportMap.values()) {
            if (airports.getId().equalsIgnoreCase(id) &&
                airports.getName().equalsIgnoreCase(name) &&
                airports.getCode().equalsIgnoreCase(code)) {
                airportsFound.add(airports);
            }
        }
        return airportsFound;
    }

}
