package com.example.service;

import com.example.objects.MoilioClRequest;
import com.example.objects.SmsTextRequest;
import com.twilio.exception.ApiException;

import java.net.URISyntaxException;

/*
 *  This is a interface used for Abstraction.
 *
 * */
public interface SmsTextService {
    boolean validateAndSendText(SmsTextRequest smsTextRequest) throws ApiException;
    boolean validateAndCalling(MoilioClRequest moilioClRequest) throws ApiException, URISyntaxException;
}
