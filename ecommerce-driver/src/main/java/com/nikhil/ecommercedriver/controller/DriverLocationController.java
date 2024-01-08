package com.nikhil.ecommercedriver.controller;

import com.nikhil.ecommercedriver.service.DriverLocationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping
public class DriverLocationController {

    private final DriverLocationService driverLocationService;

    public DriverLocationController(DriverLocationService driverLocationService) {
        this.driverLocationService = driverLocationService;
    }

    @PostMapping("/location")
    public ResponseEntity<Map<String, String>> updateLocation() throws InterruptedException {
        int range = 100;
        while(range-- > 0) {
            String location = Math.random()*10 + ", " + Math.random()*10;
            driverLocationService.updateLocation(location);
            Thread.sleep(1000);
        }

        return new ResponseEntity<>(Map.of("message", "locationUpdated"), HttpStatus.OK);
    }

    @PostMapping("/locationApi")
    public ResponseEntity<Map<String, String>> updateLocationUsingApi() throws InterruptedException {
        int range = 100;
        while(range-- > 0) {
            String location = Math.random()*10 + ", " + Math.random()*10;
            driverLocationService.updateLocationUsingApi(location);
            Thread.sleep(1000);
        }

        return new ResponseEntity<>(Map.of("message", "locationUpdatedWithApi"), HttpStatus.OK);
    }
}
