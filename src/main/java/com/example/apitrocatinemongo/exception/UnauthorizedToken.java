package com.example.apitrocatinemongo.exception;

public class UnauthorizedToken extends RuntimeException{
    public UnauthorizedToken(String message){
        super(message);
    }

}
