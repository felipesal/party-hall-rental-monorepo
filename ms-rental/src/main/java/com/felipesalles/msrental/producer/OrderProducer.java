package com.felipesalles.msrental.producer;

import com.felipesalles.msrental.Order;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.kafka.core.KafkaTemplate;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class OrderProducer {
    private String topicName;
    private KafkaTemplate<String, Order> kafkaTemplate;

    public OrderProducer(
        @Value("${topic.name}") String topicName,
        KafkaTemplate<String, Order> kafkaTemplate
    ) {
        this.topicName = topicName;
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(Order order) {
        kafkaTemplate.send(topicName, order).addCallback(
			success -> log.info("Mensagem enviada com sucesso"),
			failure -> log.error("Mensagem com falha")
		);
    }

    
}
