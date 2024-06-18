package com.keyin.aircraftInfo;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AircraftService {
   private Map<Integer, Aircraft> aircraftMap = new HashMap<Integer, Aircraft>();
   Aircraft aircraft = new Aircraft();

    public Aircraft getAircraft(Integer index) {
        return aircraftMap.get(index);
    }

    public Aircraft createAircraft(Aircraft newAircraft) {
        aircraftMap.put(aircraftMap.size() + 1, newAircraft);
        return newAircraft;
    }

    public List<Aircraft> getAllAircraft() {
        return List.copyOf(aircraftMap.values());
    }

    public Aircraft updateAircraft(Integer index, Aircraft updatedAircraft) {
        Aircraft aircraftToUpdate = aircraftMap.get(index);
        aircraftToUpdate.setId(updatedAircraft.getId());
        aircraftToUpdate.setType(updatedAircraft.getType());
        aircraftToUpdate.setAirlineName(updatedAircraft.getAirlineName());
        aircraftToUpdate.setNumberOfPassengers(updatedAircraft.getNumberOfPassengers());

        aircraftMap.put(index, aircraftToUpdate);
        return aircraftToUpdate;
    }

    public void deleteAircraft(Integer index) {
        aircraftMap.remove(index);
    }

    public List<Aircraft> findAircraftById(String id) {
        List<Aircraft> aircraftFound = new ArrayList<Aircraft>();
        for (Aircraft aircraft: aircraftMap.values()) {
            if (aircraft.getId().equalsIgnoreCase(id)) {
                aircraftFound.add(aircraft);
            }
        }
        return aircraftFound;
    }

}
