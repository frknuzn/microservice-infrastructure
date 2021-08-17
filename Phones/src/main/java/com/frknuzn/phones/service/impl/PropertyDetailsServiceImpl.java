package com.frknuzn.phones.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.frknuzn.phones.config.PhonesServiceConfig;
import com.frknuzn.phones.model.Properties;
import com.frknuzn.phones.service.PropertyDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PropertyDetailsServiceImpl implements PropertyDetailsService {

    @Autowired
    PhonesServiceConfig phonesConfig;

    @Override
    public String getPropertyDetails() {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        Properties properties = new Properties(phonesConfig.getMsg(), phonesConfig.getBuildVersion(),
                phonesConfig.getMailDetails(), phonesConfig.getActiveBranches());
        String jsonStr = null;
        try {
            jsonStr = ow.writeValueAsString(properties);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonStr;
    }
}
