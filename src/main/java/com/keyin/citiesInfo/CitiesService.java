package com.keyin.citiesInfo;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CitiesService {
    private Map<Integer, Cities> citiesMap = new HashMap<Integer, Cities>();

    public Cities getCity(Integer index) {
        return citiesMap.get(index);
    }

    public Cities createCity(Cities newCity) {
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
