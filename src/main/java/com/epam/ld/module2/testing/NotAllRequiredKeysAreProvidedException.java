package com.epam.ld.module2.testing;

public class NotAllRequiredKeysAreProvidedException extends RuntimeException{
    public NotAllRequiredKeysAreProvidedException() {
    }

    public NotAllRequiredKeysAreProvidedException(String message) {
        super(message);
    }
}
