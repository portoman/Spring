package com.portoman.springboot.helloworld;

public class BeanResponse {
    private String message;

    public BeanResponse(String message) {
        this.message = message;
    }

    public BeanResponse() {
    }

    
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    
}
