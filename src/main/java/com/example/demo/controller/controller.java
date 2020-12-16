package com.example.demo.controller;

import com.example.demo.entity.City;
import com.example.demo.sevice.CityService;
import com.example.demo.sevice.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class controller {
    @Autowired
    private CityService cityService;
    @Autowired
    private CountryService countryService;
    @GetMapping("/")
    public ModelAndView showAllCountry(){
        Iterable<City> all = cityService.findAll();
        ModelAndView modelAndView=new ModelAndView("home");
        modelAndView.addObject("list",all);
        modelAndView.addObject("emptyList",new City());
        modelAndView.addObject("country",countryService.findAll());
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable int id){
        cityService.remove(cityService.findById(id));
        ModelAndView modelAndView=new ModelAndView("home");
        modelAndView.addObject("emptyList",new City());
        Iterable<City> all = cityService.findAll();
        modelAndView.addObject("country",countryService.findAll());
        modelAndView.addObject("list",all);
        return modelAndView;
    }
    @PostMapping("create")
    public ModelAndView create(@ModelAttribute City city){
        cityService.save(city);
        ModelAndView modelAndView=new ModelAndView("home");
        Iterable<City> all = cityService.findAll();
        modelAndView.addObject("list",all);
        modelAndView.addObject("country",countryService.findAll());
        modelAndView.addObject("emptyList",new City());
        return modelAndView;
    }

    @GetMapping("fix/{id}")
    public ModelAndView fix(@PathVariable int id){
        ModelAndView modelAndView=new ModelAndView("fix");
        modelAndView.addObject("country",countryService.findAll());
        modelAndView.addObject("emptyList",cityService.findById(id));
        modelAndView.addObject("id",id);
        return modelAndView;
    }
    @PostMapping("fix")
    public ModelAndView fix(@ModelAttribute City city){
        cityService.update(city);
        ModelAndView modelAndView=new ModelAndView("home");
        Iterable<City> all = cityService.findAll();
        modelAndView.addObject("list",all);
        modelAndView.addObject("country",countryService.findAll());
        modelAndView.addObject("emptyList",new City());
        return modelAndView;
    }

}
