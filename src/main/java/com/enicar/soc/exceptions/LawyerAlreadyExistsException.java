package com.enicar.soc.exceptions;

public class LawyerAlreadyExistsException extends RuntimeException{
    public LawyerAlreadyExistsException(String message){
        super(message);
    }
}
