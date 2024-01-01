package com.nikhil.ecommercedriver.service;

import com.nikhil.ecommercedriver.constant.AppConstant;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class DriverLocationService {

    private KafkaTemplate<String, Object> kafkaTemplate;

    public DriverLocationService(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public boolean updateLocation(String location) {
        kafkaTemplate.send(AppConstant.DRIVER_LOCATION, location);
        return true;
    }
}
