package com.nikhil.ecommercedriver.controller;

import com.nikhil.ecommercedriver.service.DriverLocationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/location")
public class DriverLocationController {

    private DriverLocationService driverLocationService;

    public DriverLocationController(DriverLocationService driverLocationService) {
        this.driverLocationService = driverLocationService;
    }

    @PutMapping
    public ResponseEntity updateLocation() throws InterruptedException {
        int range = 100;
        while(range-- > 0) {
            String location = Math.random()*10 + ", " + Math.random()*10;
            driverLocationService.updateLocation(location);
            Thread.sleep(1000);
        }

        return new ResponseEntity<>(Map.of("message", "locationUpdated"), HttpStatus.OK);
    }
}
