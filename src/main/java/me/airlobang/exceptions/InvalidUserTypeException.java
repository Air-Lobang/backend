package me.airlobang.exceptions;
public class InvalidUserTypeException extends RuntimeException{
    public InvalidUserTypeException() {
        super("User Type can only be 'M' or 'C'.");
    }
    
}
