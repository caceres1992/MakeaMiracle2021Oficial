package com.code2000.makeamiracle.config;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@AllArgsConstructor
@Getter
public class ErrorDetails {

    private int statusCode;
    private Date timestamp;
    private String message;
    private String description;



}
