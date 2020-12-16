package com.example.demo.sevice;

import com.example.demo.entity.City;
import com.example.demo.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {
    @Autowired
    private CityRepository cityRepository;

    public Iterable<City> findAll() {
        return cityRepository.findAll();
    }

    public City findById(Integer id)  {
        City city = cityRepository.findById(id).get();
        return city;
    }

    public void update(City city) {
        cityRepository.save(city);
    }

    public void remove(City id) {
        cityRepository.delete(id);
    }

    public void save(City city){
        cityRepository.save(city);
    }


}
