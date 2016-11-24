package com.example.marceloaguiar.myfirstmillion.Model.Exceptions;

/**
 * Created by marceloaguiar on 11/24/16.
 */

public class WrongPasswordException extends Exception {
    public WrongPasswordException(String message) {
        super(message);
    }
}
