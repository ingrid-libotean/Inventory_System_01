package com.myapp.exceptions;

public class StorageException extends RuntimeException {
    public StorageException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
