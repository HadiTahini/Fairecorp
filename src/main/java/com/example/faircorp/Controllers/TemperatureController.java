package com.example.faircorp.Controllers;

import org.json.JSONObject;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.util.*;

@RestController
@RequestMapping("/smart-building/temperature")
@Transactional
public class TemperatureController {

    @GetMapping
    public ResponseEntity<?> getTemperature() {
        try {
            String uri="http://ws1.metcheck.com/ENGINE/v9_0/json.asp?lat=45.4397&lon=4.3872&lid=244764&Fc=No";
            RestTemplate restTemplate = new RestTemplate();
            String result = restTemplate.getForObject(uri, String.class);
            org.json.JSONObject jsonObj = new JSONObject(result);
            result = String.valueOf(jsonObj.getJSONObject("metcheckData").getJSONObject("forecastLocation").getJSONArray("forecast").getJSONObject(0).getString("temperature"));
            return new ResponseEntity<>(result, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("Error!, Please try again", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
