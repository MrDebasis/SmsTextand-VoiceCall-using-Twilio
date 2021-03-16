package com.example.api.v1;

import com.example.objects.MoilioClRequest;
import com.example.objects.SmsTextRequest;
import com.twilio.exception.ApiException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.net.URISyntaxException;

/*
 * This interface is used for mapping the URI's and provide the abstraction
 * @Param SmsTextRequest
 * @Return String
 * */
@RequestMapping("/api/v1")
@Validated
public interface TextSms {
    @PostMapping("/send")
    String sendTextSms(@Valid @RequestBody SmsTextRequest SmsTextRequest) throws ApiException;
    @PostMapping("/call")
    String makeAcall(@Valid @RequestBody MoilioClRequest moilioClRequest) throws ApiException, URISyntaxException;
}

