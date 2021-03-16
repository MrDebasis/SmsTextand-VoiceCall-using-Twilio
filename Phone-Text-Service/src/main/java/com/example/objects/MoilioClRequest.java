package com.example.objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString
public class MoilioClRequest {
    @JsonProperty("to")
    @NotBlank
    private String toPhoneNumber;
}

