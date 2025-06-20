package com.parkmate.parkingreadservice.kafka.config;

import com.parkmate.parkingreadservice.kafka.event.OperationCreateEvent;
import com.parkmate.parkingreadservice.kafka.constant.KafkaConsumerGroups;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;

@Configuration
public class OperationKafkaConfig extends CommonKafkaConfig {

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, OperationCreateEvent> parkingLotOperationCreatedListener() {
        return createListenerFactory(OperationCreateEvent.class, KafkaConsumerGroups.parkingLotOperationCreatedGroup);
    }
}
