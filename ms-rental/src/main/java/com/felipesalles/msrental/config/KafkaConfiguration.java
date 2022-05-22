package com.felipesalles.msrental.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConfiguration {
    
    private String topic;

    public KafkaConfiguration(@Value("${topic.name}") String topic) {
        this.topic = topic;
    }

    @Bean
    public NewTopic createNewTopic() {
        return new NewTopic(topic, 1, (short)1);
    }
}
