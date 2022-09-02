package com.example.UserNotification.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class ErrorResponse implements Serializable {
    private Date timestamp;
    private String message;
    private String details;
}