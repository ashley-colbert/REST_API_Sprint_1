package com.keyin.passengerInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class PassengerController {
    @Autowired
    private PassengerService passengerService;

    @GetMapping("search_passenger")
    public List<Passengers> searchPassengers(@RequestParam(value = "id", required = false) String id) {
        return passengerService.findPassengerById(id);
    }

    @GetMapping("passengers")
    public List<Passengers> getAllPassengers() {
        return passengerService.getAllPassengers();
    }

    @GetMapping("passenger/{index}")
    public Passengers getPassenger(@PathVariable Integer index) {
        return passengerService.getPassenger(index);
    }

    @PostMapping("passenger")
    public Passengers createPassenger(@RequestBody Passengers newPassenger, @RequestParam(value = "aircraftId", required = false)String aircraftId, @RequestParam(value = "airportCode", required = false) String airportCode) {
        return passengerService.createPassenger(newPassenger, aircraftId, airportCode);
    }

    @PutMapping("passenger/{index}")
    public Passengers updatePassenger(@PathVariable Integer index, @RequestBody Passengers updatedPassenger) {
        return passengerService.updatePassenger(index, updatedPassenger);
    }

    @PutMapping("passenger/aircraft/{index}")
    public Passengers updatePassengerAircraft(@PathVariable Integer index, @RequestParam(value = "aircraftId", required = false) String aircraftId) {
        return passengerService.updatePassengerAircraft(index, aircraftId);
    }

    @PutMapping("passenger/airport/{index}")
    public Passengers updatePassengerAirport(@PathVariable Integer index, @RequestParam(value = "airportCode", required = false) String airportCode) {
        return passengerService.updatePassengerAirport(index, airportCode);
    }

    @DeleteMapping("passenger/{index}")
    public void deletePassenger(@PathVariable Integer index) {
        passengerService.deletePassenger(index);
    }
}
