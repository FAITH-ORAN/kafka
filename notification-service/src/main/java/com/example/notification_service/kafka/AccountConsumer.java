package com.example.notification_service.kafka;


import com.example.notification_service.thirdParty.dto.AccountEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class AccountConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountConsumer.class);

    @KafkaListener(topics = "${spring.kafka.topic.name}"
    ,groupId = "${spring.kafka.consumer.group-id}")
    public void consume(AccountEvent accountEvent){
        LOGGER.info(String.format("Account event received in notification service => %s", accountEvent.toString()));

    }
}
