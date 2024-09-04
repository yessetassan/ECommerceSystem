package com.yesko.project.configuration;


import com.yesko.project.kafka.OrderConfirmation;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

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
