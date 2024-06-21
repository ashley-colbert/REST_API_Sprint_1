package com.keyin.citiesInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController@CrossOrigin
public class CitiesController {
    @Autowired
    private CitiesService citiesService;

    @GetMapping("search_cities")
    public List<Cities> searchCities(@RequestParam(value = "id", required = false) String id) {
        return citiesService.findCitiesById(id);
    }

    @GetMapping("cities")
    public List<Cities> getAllCities() {
        return citiesService.getAllCities();
    }

    @GetMapping("cities/{index}")
    public Cities getCity(@RequestBody Integer index) {
        return citiesService.getCity(index);
    }

    @PostMapping("city")
    public  Cities createCity(@RequestBody Cities newCity, @RequestParam (value ="airportCode", required = false) String airportCode) {
        return citiesService.createCity(newCity, airportCode);
    }

    @PutMapping("city/{index}")
    public Cities updatedCity(@PathVariable Integer index, @RequestBody Cities updatedCity) {
        return citiesService.updateCity(index, updatedCity);
    }

    @PutMapping("city/airport/{index}")
    public Cities updateCityAirports(@PathVariable Integer index, @RequestParam(value = "airportCode", required = false) String airportCode) {
        return citiesService.updateCityAirports(index, airportCode);
    }

    @DeleteMapping
    public void deleteCity(@PathVariable Integer index) {
        citiesService.deleteCity(index);
    }
}
