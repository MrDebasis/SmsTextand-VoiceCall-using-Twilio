package com.example.objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

/*
 *  This is a object class used for map the JSON Request
 *
 * */
@Getter
@Setter
@ToString
public class SmsTextRequest {
    @JsonProperty("to")
    @NotBlank
    private String toPhoneNumber;
    @JsonProperty("message")
    @NotBlank
    private String message;
}
