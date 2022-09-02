package com.example.UserNotification.utils;

import org.springframework.http.HttpStatus;

public class Util {
    public static Response getOkRequest(Object data){
        Response response = new Response();
        response.setData(data);
        response.setStatus(Constant.SUCCESS);
        response.setHttpStatus(HttpStatus.OK);
        return response;
    }
    public static Response getBadRequest(Object data){
        Response response = new Response();
        response.setData(data);
        response.setStatus(Constant.FAIL);
        response.setHttpStatus(HttpStatus.BAD_REQUEST);
        return response;
    }
}
