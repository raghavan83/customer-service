package com.edureka.hotelreservationsystem.customerservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.edureka.hotelreservationsystem.customerservice.dto.EventMessage;

@Component
public class EventPublisher {

	@Autowired
    private KafkaTemplate<String,EventMessage> kafkaTemplate;

    public void publishEvent(EventMessage event) {
        kafkaTemplate.send("customer-topic", event);
    }
}
