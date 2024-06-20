package com.keyin.airportInfo;

import com.keyin.citiesInfo.Cities;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AirportService {
    private Map<Integer, Airports> airportMap = new HashMap<Integer, Airports>();

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

    public List<Airports> findAirportByCode(String code) {
        List<Airports> airportsFound = new ArrayList<Airports>();

        for (Airports airports : airportMap.values()) {
            if (airports.getCode().equalsIgnoreCase(code)) {
                airportsFound.add(airports);
            }
        }
            return airportsFound;
        }

}
