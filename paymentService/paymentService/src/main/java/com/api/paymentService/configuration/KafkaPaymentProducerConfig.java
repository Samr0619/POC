package com.api.paymentService.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaPaymentProducerConfig {

    @Bean
    public NewTopic getNewTopic(){
        return TopicBuilder
                .name("createShipment")
                .build();
    }
}
