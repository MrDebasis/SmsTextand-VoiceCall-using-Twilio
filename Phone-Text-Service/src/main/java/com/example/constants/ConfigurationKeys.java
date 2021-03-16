package com.example.constants;

/*
 * This is a constant class. Used for collect the external config keys.
 *
 * */
public class ConfigurationKeys {
    public static final String ACCOUNT_SID = "twilio.account_sid";
    public static final String ACCESS_TOKEN = "twilio.auth_token";
    public static final String TRIAL_PHONE_NUMBER = "twilio.trial_number";

    /*
     * Used for block the instantiation.
     *
     * */
    private ConfigurationKeys() {

    }
}
