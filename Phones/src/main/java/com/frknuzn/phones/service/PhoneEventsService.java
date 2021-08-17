package com.frknuzn.phones.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.frknuzn.phones.model.PhoneEvent;
import com.frknuzn.phones.repository.PhonesRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.RecoverableDataAccessException;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.Optional;

@Service
@Slf4j
public class PhoneEventsService {

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    KafkaTemplate<Integer, String> kafkaTemplate;

    @Autowired
    private PhonesRepository phonesRepository;

    public void processPhoneEvent(ConsumerRecord<Integer, String> consumerRecord) {
        PhoneEvent phoneEvent = null;
        try {
            phoneEvent = objectMapper.readValue(consumerRecord.value(), PhoneEvent.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        if (phoneEvent.getPhoneEventId() != null && phoneEvent.getPhoneEventId() == 000) {
            throw new RecoverableDataAccessException("Temporary Network Issue");
        }
        try {
            phoneEvent = objectMapper.readValue(consumerRecord.value(), PhoneEvent.class);
        } catch (JsonProcessingException e) {
            log.error("Processing Failed : {}", e.getMessage());
        }
        log.info("phoneEvent : {} ", phoneEvent);

        save(phoneEvent);
    }

    private void save(PhoneEvent phoneEvent) {
        phoneEvent.getPhone().setPhoneEvent(phoneEvent);
        phonesRepository.save(phoneEvent);
        log.info("Successfully Persisted the phone Event {} ", phoneEvent);
    }

    public void handleRecovery(ConsumerRecord<Integer, String> record) {

        Integer key = record.key();
        String message = record.value();

        ListenableFuture<SendResult<Integer, String>> listenableFuture = kafkaTemplate.sendDefault(key, message);
        listenableFuture.addCallback(new ListenableFutureCallback<SendResult<Integer, String>>() {
            @Override
            public void onFailure(Throwable ex) {
                handleFailure(key, message, ex);
            }

            @Override
            public void onSuccess(SendResult<Integer, String> result) {
                handleSuccess(key, message, result);
            }
        });
    }

    private void handleFailure(Integer key, String value, Throwable ex) {
        log.error("Error Sending the Message and the exception is {}", ex.getMessage());
        try {
            throw ex;
        } catch (Throwable throwable) {
            log.error("Error in OnFailure: {}", throwable.getMessage());
        }
    }

    private void handleSuccess(Integer key, String value, SendResult<Integer, String> result) {
        log.info("Message Sent SuccessFully for the key : {} and the value is {} , partition is {}", key, value, result.getRecordMetadata().partition());
    }
}
