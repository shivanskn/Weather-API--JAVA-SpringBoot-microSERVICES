package mydata.com.mydataWeather.controller;



import java.util.ArrayList;


import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import mydata.com.mydataWeather.service.*;

import mydata.com.mydataWeather.model.*;


@RestController
public class MydataWeatherController {
	
	@Autowired
//    private final MydataWeatherService mydataWeatherService;
	
	 private  MydataWeatherService mydataWeatherService;


//    @Autowired
//    public MydataWeatherController(MydataWeatherService mydataWeatherService) {
//    	System.out.println("I am in weather controller 1");
//        this.mydataWeatherService = mydataWeatherService;
//        System.out.println("I am in weather controller 2");
//    }
	
    @RequestMapping("/")
    String home() {
        return "Hello shiv!";
    }
    
    
    @RequestMapping("weather/{city}")
	public List<Example> getWeather(
			@PathVariable String city) {
		System.out.println("I am in weather controller 4");
		return this.mydataWeatherService.getWeather(city);		
		
	
	}
	
   
}
