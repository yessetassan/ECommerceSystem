package com.yesko.project.configuration;


import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import static com.yesko.project.utils.Constanta.ORDER_TOPIC;

@Configuration
public class KafkaOrderTopicConfig {
    @Bean
    public NewTopic orderTopic(){
        return TopicBuilder
                .name(ORDER_TOPIC)
                .build();
    }
}
