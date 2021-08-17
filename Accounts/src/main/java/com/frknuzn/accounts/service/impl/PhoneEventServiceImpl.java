package com.frknuzn.accounts.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.frknuzn.accounts.model.PhoneEvent;
import com.frknuzn.accounts.producer.PhoneServiceEventProducer;
import com.frknuzn.accounts.service.PhoneEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhoneEventServiceImpl implements PhoneEventService {

    @Autowired
    PhoneServiceEventProducer phoneServiceEventProducer;


    @Override
    public void sendPhoneEvent(PhoneEvent phoneEvent) {
        try {
            phoneServiceEventProducer.sendPhoneEvent_Approach(phoneEvent);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
