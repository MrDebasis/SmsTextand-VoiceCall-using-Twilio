package com.example.config;

import com.example.constants.ConfigurationKeys;
import com.twilio.Twilio;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/*
 *  this configuration class is used for Initialize the connection to twilio.
 *  @Param ACCOUNT_UID
 *  @Param ACCESS_TOKEN
 *
 * */
@Configuration
@Slf4j
public class TwilioInitializer {
    @Autowired
    private final Environment environment;

    @Autowired
    public TwilioInitializer(Environment environment) {
        log.info("Initialize starts for twilio");
        this.environment = environment;
        Twilio.init(
                environment.getProperty(ConfigurationKeys.ACCOUNT_SID),
                environment.getProperty(ConfigurationKeys.ACCESS_TOKEN)
        );
        log.info("Connecting twilio successfully");
    }

}



