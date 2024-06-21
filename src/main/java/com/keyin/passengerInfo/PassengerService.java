package com.keyin.passengerInfo;

import com.keyin.aircraftInfo.Aircraft;
import com.keyin.aircraftInfo.AircraftService;
import com.keyin.airportInfo.AirportService;
import com.keyin.airportInfo.Airports;
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

    @Autowired
    private AirportService airportService;

    public Passengers getPassenger(Integer index) {
        return passengerMap.get(index);
    }

    public Passengers createPassenger(Passengers newPassenger, String aircraftId, String airportCode) {
        if (newPassenger.getAircraft() == null) {
            newPassenger.setAircraft(new ArrayList<>());
        }
        List<Aircraft> aircraftFound = aircraftService.findAircraftById(aircraftId);
        newPassenger.getAircraft().addAll(aircraftFound);

        if(newPassenger.getAirports() == null) {
            newPassenger.setAirports(new ArrayList<>());
        }
        List<Airports> airportFound = airportService.findAirportByCode(airportCode);
        newPassenger.getAirports().addAll(airportFound);

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
        List<Aircraft> aircraftList = aircraftService.findAircraftById(aircraftId);
        passengerToUpdate.getAircraft().addAll(aircraftList);

        passengerMap.put(index, passengerToUpdate);
        return passengerToUpdate;
    }

    public Passengers updatePassengerAirport(Integer index, String airportCode) {
        Passengers passengerToUpdate = passengerMap.get(index);
        List<Airports> airportsList = airportService.findAirportByCode(airportCode);
        passengerToUpdate.getAirports().addAll(airportsList);

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
