package com.trackly.backend.exception;

public class ApplicationNotFoundException extends RuntimeException{
    public ApplicationNotFoundException(String id)
    {
        super("Application not found: " + id);
    }
}
