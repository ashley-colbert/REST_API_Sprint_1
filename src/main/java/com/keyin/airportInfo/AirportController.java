package com.keyin.airportInfo;

import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
public class AirportController {
    @Autowired
    private AirportService airportService;

    @GetMapping("search_airports")
    public List<Airports> searchAirports(@RequestParam(value = "id", required = false) String id, @RequestParam(value = "name", required = false) String name, @RequestParam(value = "code", required = false) String code) {
        return airportService.findAirportByIdNameCode(id, name, code);
    }

    @GetMapping("airports")
    public List<Airports> getAllAirports() {
        return airportService.getAllAirports();
    }

    @GetMapping("airport/{index}")
    public Airports getAirport(@PathVariable Integer index) {
        return airportService.getAirport(index);
    }

    @PostMapping("airport")
    public Airports createAirport(@RequestBody Airports newAirport) {
        return airportService.createAirport(newAirport);
    }

    @PutMapping("airport/{index}")
    public Airports updateAirport(@PathVariable Integer index, @RequestBody Airports updatedAirport) {
        return airportService.updateAirport(index, updatedAirport);
    }

    @DeleteMapping("airport/{index}")
    public void deleteAirport(@PathVariable Integer index) {
        airportService.deleteAirport(index);
    }
}
