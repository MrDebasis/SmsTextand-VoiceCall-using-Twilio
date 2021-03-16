package com.example.controller;

import com.example.api.v1.TextSms;
import com.example.objects.MoilioClRequest;
import com.example.objects.SmsTextRequest;
import com.example.service.SmsTextService;
import com.twilio.exception.ApiException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URISyntaxException;

/*
 *  This is a controller class used for handle the request and provide response to user.
 *  @Param SmsTextRequest
 *  @Return String
 *  @Throws ApiException
 * */
@RestController
@Slf4j
public class SmsTextController implements TextSms {
    @Autowired
    private SmsTextService smsTextService;

    @Override
    public String sendTextSms(@Valid SmsTextRequest smsTextRequest) throws ApiException {
        log.info("Sending Message to user");
        boolean b = smsTextService.validateAndSendText(smsTextRequest);
        if (b) {
            return "Text Message Send Successfully";
        }
        return "Something Went Wrong";

    }

    /*
     *  This method is used for calling to user.
     *  @Param phoneNumber
     *  @Return String
     *  @Throws ApiException,URISyntaxException
     * */
    @Override
    public String makeAcall(MoilioClRequest moilioClRequest) throws ApiException, URISyntaxException {
        log.info("calling to user");
        boolean b = smsTextService.validateAndCalling(moilioClRequest);
        if (b) {
            return "cl got success ";
        }
        return "Something Went Wrong";
    }
}
