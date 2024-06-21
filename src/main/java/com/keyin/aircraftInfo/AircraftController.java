package com.keyin.aircraftInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class AircraftController {
    @Autowired
    private AircraftService aircraftService;

    @GetMapping("Search-aircraft")
    public List<Aircraft> searchAircraft(@RequestParam(value = "id", required = false) String id) {
        return aircraftService.findAircraftById(id);
    }

    @GetMapping("aircraft")
    public List<Aircraft> getAllAircraft() {
        return aircraftService.getAllAircraft();
    }

    @GetMapping("aircraft/{index}")
    public Aircraft getAircraft(@PathVariable Integer index) {
        return aircraftService.getAircraft(index);
    }

    @PostMapping("aircraft")
    public Aircraft createAircraft(@RequestBody Aircraft newAircraft, @RequestParam(value = "airportCode", required = false) String airportCode) {
        return aircraftService.createAircraft(newAircraft, airportCode);
    }

    @PutMapping("aircraft/{index}")
    public Aircraft updateAircraft(@PathVariable Integer index, @RequestBody Aircraft updatedAircraft) {
        return aircraftService.updateAircraft(index, updatedAircraft);
    }

    @PutMapping("aircraft/takeoff/{index}")
    public Aircraft updateAircraftTakeOff(@PathVariable Integer index, @RequestParam(value = "airportCode", required = false) String airportCode) {
        return aircraftService.updateAircraftTakeOff(index, airportCode);
    }

    @PutMapping("aircraft/land/{index}")
    public Aircraft updateAircraftLand(@PathVariable Integer index, @RequestParam(value = "airportCode", required = false) String airportCode) {
        return aircraftService.updateAircraftLand(index, airportCode);
    }

    @DeleteMapping("aircraft/{index}")
    public void deleteAircraft(@PathVariable Integer index) {
        aircraftService.deleteAircraft(index);
    }
}
