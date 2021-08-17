package com.frknuzn.accounts.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.frknuzn.accounts.config.AccountServiceConfig;
import com.frknuzn.accounts.model.Properties;
import com.frknuzn.accounts.service.PropertyDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PropertyDetailsServiceImpl implements PropertyDetailsService {

    @Autowired
    AccountServiceConfig accountsConfig;

    @Override
    public String getPropertyDetails() {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        Properties properties = new Properties(accountsConfig.getMsg(), accountsConfig.getBuildVersion(),
                accountsConfig.getMailDetails(), accountsConfig.getActiveBranches());
        String jsonStr = null;
        try {
            jsonStr = ow.writeValueAsString(properties);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonStr;
    }
}
