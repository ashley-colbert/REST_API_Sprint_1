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
    public Passengers createPassenger(@RequestBody Passengers newPassenger) {
        return passengerService.createPassenger(newPassenger);
    }

    @PutMapping("passenger/{index}")
    public Passengers updatePassenger(@PathVariable Integer index, @RequestBody Passengers updatedPassenger) {
        return passengerService.updatePassenger(index, updatedPassenger);
    }

    @DeleteMapping("passenger/{index}")
    public void deletePassenger(@PathVariable Integer index) {
        passengerService.deletePassenger(index);
    }
}
