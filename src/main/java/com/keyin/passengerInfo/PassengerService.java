package com.keyin.passengerInfo;

import com.keyin.aircraftInfo.Aircraft;
import com.keyin.aircraftInfo.AircraftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PassengerService {
    private Map<Integer, Passengers> passengerMap = new HashMap<Integer, Passengers>();
    @Autowired
    private AircraftService aircraftService;

    public Passengers getPassenger(Integer index) {
        return passengerMap.get(index);
    }

    public Passengers createPassenger(Passengers newPassenger, String aircraftId) {
        if (newPassenger.getAircraft() == null) {
            newPassenger.setAircraft(new ArrayList<>());
        }
        List<Aircraft> aircraftFound = aircraftService.findAircraftById(aircraftId);

        newPassenger.getAircraft().addAll(aircraftFound);

        passengerMap.put(passengerMap.size() + 1, newPassenger);
        return newPassenger;
    }

    public List<Passengers> getAllPassengers() {
        return List.copyOf(passengerMap.values());
    }


    public Passengers updatePassenger(Integer index, Passengers updatedPassenger) {
        Passengers passengerToUpdate = passengerMap.get(index);

        passengerToUpdate.setId(updatedPassenger.getId());
        passengerToUpdate.setFirstName(updatedPassenger.getFirstName());
        passengerToUpdate.setLastName(updatedPassenger.getLastName());
        passengerToUpdate.setPhoneNumber(updatedPassenger.getPhoneNumber());


        passengerMap.put(index, passengerToUpdate);
        return passengerToUpdate;
    }

    public Passengers updatePassengerAircraft(Integer index, String aircraftId) {
        Passengers passengerToUpdate = passengerMap.get(index);

        if (passengerToUpdate == null) {
            throw new IllegalArgumentException("Passenger not found with index: " + index);
        }
        if (aircraftId != null && !aircraftId.isEmpty()) {
            List<Aircraft> aircraftList = aircraftService.findAircraftById(aircraftId);
            if (aircraftList.isEmpty()) {
                throw new IllegalArgumentException("Aircraft not found with ID: " + aircraftId);
            }
            passengerToUpdate.getAircraft().addAll(aircraftList);
        }
        passengerMap.put(index, passengerToUpdate);

        return passengerToUpdate;
    }


    public void deletePassenger(Integer index) {
        passengerMap.remove(index);
    }



    public List<Passengers> findPassengerById(String id) {
        List<Passengers> passengerFound = new ArrayList<Passengers>();
        for (Passengers passenger: passengerMap.values()) {
            if (passenger.getId().equalsIgnoreCase(id)) {
                passengerFound.add(passenger);
            }
        }
        return passengerFound;
    }

}
