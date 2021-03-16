package com.example.service;

import com.example.constants.ConfigurationKeys;
import com.example.objects.MoilioClRequest;
import com.example.objects.SmsTextRequest;

import com.example.service.exception.*;
import com.twilio.exception.ApiException;
import com.twilio.rest.api.v2010.account.Call;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import java.net.URI;
import java.net.URISyntaxException;

/*
 *  Service class used for send the message using phoneNumber through twilio.
 *  @Param SmsTextRequest
 *  @Throws ApiException
 *
 * */
@Service
@Slf4j
public class SmsTextServiceImpl implements SmsTextService {
    @Autowired
    private Environment environment;

    @Override
    public boolean validateAndSendText(SmsTextRequest smsTextRequest) throws ApiException {
        log.info("Validating The phone number");
        try {
            if (isPhoneNumberValid(String.format("+91", smsTextRequest.getToPhoneNumber()))) {
                PhoneNumber to = new PhoneNumber(smsTextRequest.getToPhoneNumber());
                PhoneNumber from = new PhoneNumber(environment.getProperty(ConfigurationKeys.TRIAL_PHONE_NUMBER));
                String message = smsTextRequest.getMessage();
                MessageCreator creator = Message.creator(to, from, message);
                creator.create();
                log.info("send message successfully");
            } else {
                log.error("While sending message getting error ");
            }
        } catch (HttpClientErrorException | HttpServerErrorException.InternalServerError e) {
            handlingException(e.getStatusCode());
        }
        return true;
    }

    /*
     *  Service method used for make a cl through twilio.
     *  @Param MoilioClRequest
     *  @Throws ApiException
     *
     * */
    @Override
    public boolean validateAndCalling(MoilioClRequest moilioClRequest) throws ApiException, URISyntaxException {
        log.info("Validating The phone number for calling service");
        try {
            if (isPhoneNumberValid(String.format("+91", moilioClRequest.getToPhoneNumber()))) {
                String from = environment.getProperty(ConfigurationKeys.TRIAL_PHONE_NUMBER);
                Call.creator(new PhoneNumber(moilioClRequest.getToPhoneNumber()), new PhoneNumber(from),
                        new URI("http://demo.twilio.com/docs/voice.xml")).create();
                log.info(" cl success");
            } else {
                log.error("While calling getting error ");

            }
        } catch (HttpClientErrorException | HttpServerErrorException.InternalServerError e) {
            handlingException(e.getStatusCode());
        }


        return true;
    }

    /*
     *  Service method used for validating the phoneNumber.
     *  @Param phoneNumber
     *
     * */
    private boolean isPhoneNumberValid(String phoneNumber) {
        log.info("Validated successfully The phone number");
        return true;
    }

    /*
     *  Service method used for handling the exceptions.
     *  @Param HttpStatus
     *  @Throw  ApiException
     *
     * */
    private ApiException handlingException(HttpStatus e) throws ApiException {
        switch (e) {
            case BAD_REQUEST:
                throw new ExceptionForBadRequest("Invalid Request",
                        400,
                        "The server could not understand request due to invalid syntax",
                        400, new Throwable());
            case NOT_FOUND:
                throw new ExceptionForNotFound("Not found",
                        404,
                        "Please enter valid url",
                        404, new Throwable());
            case FORBIDDEN:
                throw new ExceptionForFrobidden("Forbidden",
                        403,
                        "The client doesn't have access for this content",
                        403, new Throwable());

            case UNAUTHORIZED:
                throw new ExceptionForUnauthorized("Unauthenticated ",
                        401,
                        "Unauthenticated Please check the credentials",
                        401,
                        new Throwable());

            case METHOD_NOT_ALLOWED:
                throw new ExceptionForMethodNotAllowed("Method is not allowed",
                        405,
                        "Method is disabled by server cant use it",
                        405,
                        new Throwable());
            case REQUEST_TIMEOUT:
                throw new ExceptionForRequestTimeOut("Request TimeOut",
                        408,
                        "while connecting to server its taking time please try again", 408,
                        new Throwable());

            case INTERNAL_SERVER_ERROR:
                throw new InternalServerError("InternalServerException", 500,
                        "Server is not available", 500, new Throwable());

            default:
                log.error("Undefined Error");
        }
        return new ApiException("");
    }
}