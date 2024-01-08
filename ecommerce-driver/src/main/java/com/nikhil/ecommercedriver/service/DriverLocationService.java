package com.nikhil.ecommercedriver.service;

import com.nikhil.ecommercedriver.constant.AppConstant;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DriverLocationService {

    private final KafkaTemplate<String, Object> kafkaTemplate;
    private final KafkaProducer<String, Object> kafkaProducer;

    public DriverLocationService(KafkaTemplate<String, Object> kafkaTemplate, KafkaProducer<String, Object> kafkaProducer) {
        this.kafkaTemplate = kafkaTemplate;
        this.kafkaProducer = kafkaProducer;
    }

    public void updateLocation(String location) {
        try {
            kafkaTemplate.send(AppConstant.DRIVER_LOCATION, location);
        } catch (Exception e) {
            log.error("Exception in sending message to Kafka", e);
        }
    }

    public void updateLocationUsingApi(String location) {
        try {
            kafkaProducer.send(new ProducerRecord<>(AppConstant.DRIVER_LOCATION, location));
        } catch (Exception e) {
            log.error("Exception in sending message to Kafka using API ", e);
        }
    }
}
