package com.trackly.backend.application.exception;

public class ApplicationNotFoundException extends RuntimeException{
    public ApplicationNotFoundException(String id)
    {
        super("Application not found: " + id);
    }
}
