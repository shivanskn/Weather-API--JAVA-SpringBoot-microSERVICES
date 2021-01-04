package mydata.com.mydataWeather.service;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import mydata.com.mydataWeather.model.*;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


@Service
//public class MydataWeatherService extends MappingJackson2HttpMessageConverter   {
public class MydataWeatherService   {

//    private static MydataWeatherService ourInstance = new MydataWeatherService();
    
//    public static MydataWeatherService getInstance() {
//    	System.out.println("I am in weather service1");
//        return ourInstance;
//    }

//    private MydataWeatherService() {
//    	setPrettyPrint(true);
//    }
    
    public List<Example> getWeather(String city) {
    	   
    	System.out.println("I am in weather service3");
    	String websiteResponse = "http://api.openweathermap.org/xxxx/x.x/xxxxxxx?x="+ city + "&mode=json&appid="+"PASTE YOUR KEY GENERATED IN OPENWEATHERMAP.ORG"+"&units=metric";


    	
    	RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(websiteResponse, String.class);	 
    	
        
        System.out.println("websiteResponse: " +websiteResponse);
        System.out.println("restTemplate: " +restTemplate);
        System.out.println("result: " +result);
        
        
        String description = null;
        String WeatherCondition = null;
        double temp;
        double temp_min;
        double temp_max;
        double pressure;
        int humidity;
       
        
        List<Example> weatherList = new ArrayList<>();
        
        System.out.println("weatherList: " +weatherList);
        
              
        JSONObject root = new JSONObject(result);
       
        System.out.println("Root :" + root);

        JSONArray weatherObject = root.getJSONArray("weather");
       
        
        System.out.println("Weather: " +weatherObject);
  

        for (int i = 0; i < weatherObject.length(); i++) {
            JSONObject elementInArray = weatherObject.getJSONObject(i);
            description = elementInArray.getString("description");
            WeatherCondition = elementInArray.getString("main");
            
            System.out.println("description: " +description);
            
            System.out.println("WeatherCondition: " +WeatherCondition);
        }

        JSONObject main = root.getJSONObject("main");
        
        System.out.println("main: " +main);
        
       
        temp = (int) main.getFloat("temp");
        
        
        System.out.println("temp: " +temp);
        
        pressure = main.getInt("pressure");
        
        humidity = main.getInt("humidity");
        System.out.println("humidity: " +humidity);
        
        temp_min= (int) main.getFloat("temp_min");
        temp_max= (int) main.getFloat("temp_max");
        System.out.println("temp_max: " +temp_max);
 
        
            TodaysWeather tw=new TodaysWeather();
            System.out.println("tw: " +tw);
            
            Example e=new Example();
            System.out.println("e: " +e);
            
            Today t=new Today();
            System.out.println("t: " +t);
            
            t.setDescription(description);
            
            t.setHumidity(humidity);
            t.setMain(WeatherCondition);
            t.setPressure(pressure);
           
            t.setTemp(temp);
            t.setTempMax(temp_max);
            t.setTempMin(temp_min);
             
            tw.setToday(t);  
            e.setTodaysWeather(tw);
            
         weatherList.add(e);
		return weatherList;
    }
} 
