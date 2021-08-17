package com.frknuzn.accounts.controller;

import com.frknuzn.accounts.model.PhoneEvent;
import com.frknuzn.accounts.service.PhoneEventService;
import com.frknuzn.accounts.service.PropertyDetailsService;
import io.micrometer.core.annotation.Timed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountsController {

    @Autowired
    private PhoneEventService phoneEventService;

    @Autowired
    PropertyDetailsService propertyDetailsService;


    @PostMapping("/myAccount")
    @Timed(value = "getAccountDetails.time", description = "Time taken to return Account Details")
    public ResponseEntity<PhoneEvent> getAccountDetails(@RequestBody PhoneEvent phoneEvent) {
        phoneEventService.sendPhoneEvent(phoneEvent);
        return ResponseEntity.status(HttpStatus.CREATED).body(phoneEvent);
    }

    @GetMapping("/account/properties")
    public String getPropertyDetails() {
        return propertyDetailsService.getPropertyDetails();
    }
}
