package com.frknuzn.phones.controller;

import com.frknuzn.phones.service.PropertyDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PhonesController {

    @Autowired
    PropertyDetailsService propertyDetailsService;

    @GetMapping("/phones/properties")
    public String getPropertyDetails() {
        return propertyDetailsService.getPropertyDetails();
    }
}
