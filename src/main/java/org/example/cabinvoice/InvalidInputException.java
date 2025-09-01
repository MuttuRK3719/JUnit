package org.example.cabinvoice;

public class InvalidInputException extends RuntimeException{
    @Override
    public String getMessage() {
        return "Invalid input  details ";
    }
}
