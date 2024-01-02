package com.api.orderService.cofiguration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaProducerConf {

    @Bean
    public NewTopic getNewTopic(){
        return TopicBuilder
                .name("NewOrder-Topic")
                .build();
    }

}
