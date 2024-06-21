package com.keyin.citiesInfo;

import com.keyin.aircraftInfo.Aircraft;
import com.keyin.airportInfo.AirportService;
import com.keyin.airportInfo.Airports;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CitiesService {

    private Map<Integer, Cities> citiesMap = new HashMap<Integer, Cities>();
    @Autowired
    private AirportService airportService;
    public Cities getCity(Integer index) {
        return citiesMap.get(index);
    }

    public Cities createCity(Cities newCity, String airportCode) {
        if (newCity.getAirports() == null) {
            newCity.setAirports(new ArrayList<>());
        }
        List<Airports> airportsFound = airportService.findAirportByCode(airportCode);

        newCity.getAirports().addAll(airportsFound);

        citiesMap.put(citiesMap.size() +1, newCity);
        return newCity;
    }

    public List<Cities> getAllCities() {
        return List.copyOf(citiesMap.values());
    }

    public Cities updateCity(Integer index, Cities updatedCity) {
        Cities cityToUpdate = citiesMap.get(index);
        cityToUpdate.setId(updatedCity.getId());
        cityToUpdate.setName((updatedCity.getName()));
        cityToUpdate.setState(updatedCity.getState());
        cityToUpdate.setPopulation(updatedCity.getPopulation());

        citiesMap.put(index, cityToUpdate);
        return cityToUpdate;
    }

    public Cities updateCityAirports(Integer index, String airportCode) {
        Cities cityToUpdate = citiesMap.get(index);
        List<Airports>airportList = airportService.findAirportByCode(airportCode);
        cityToUpdate.getAirports().addAll(airportList);

        citiesMap.put(index, cityToUpdate);
        return cityToUpdate;
    }

    public void deleteCity(Integer index) {
        citiesMap.remove(index);
    }

    public List<Cities> findCitiesById(String id) {
        List<Cities> citiesFound = new ArrayList<Cities>();
        for (Cities cities: citiesMap.values()) {
            if (cities.getId().equalsIgnoreCase(id)) {
                citiesFound.add(cities);
            }
        }
        return citiesFound;
    }

}
