package com.fineuploader.io;

/**
 * Created by ovaldez on 11/13/16.
 */
public class StorageException extends RuntimeException {

    public StorageException(String message) {
        super(message);
    }

    public StorageException(String message, Throwable cause) {
        super(message, cause);
    }

}
