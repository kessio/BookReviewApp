package com.team110.bookreview.apiresponse;

import org.springframework.stereotype.Service;

@Service
public class Response<T> {

    public APIResponse<T> success(T payload) {
        return new APIResponse<T>("Request Successful", true, payload);
    }

    public APIResponse<T> failure(T payload) {
        return new APIResponse<T>("Request Failed", false,payload);
    }
}