package com.example.demo.sevice;

import com.example.demo.entity.City;
import com.example.demo.entity.Country;
import com.example.demo.repository.CityRepository;
import com.example.demo.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public Iterable<Country> findAll() {
        return countryRepository.findAll();
    }

    public Country findById(Integer id)  {
        Country country = countryRepository.findById(id).get();
        return country;
    }

    public void update(Country country) {
        countryRepository.save(country);
    }

    public void remove(Country id) {
        countryRepository.delete(id);
    }

    public void save(Country country){
        countryRepository.save(country);
    }
}
