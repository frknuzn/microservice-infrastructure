package com.frknuzn.phones.consumer;


import com.frknuzn.phones.service.PhoneEventsService;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class PhoneEventsConsumer {

    @Autowired
    PhoneEventsService phoneEventsService;

    @KafkaListener(topics = {"phone-events"})
    public void onMessage(ConsumerRecord<Integer, String> consumerRecord)  {

        log.info("ConsumerRecord : {} ", consumerRecord);
        phoneEventsService.processPhoneEvent(consumerRecord);

    }
}
