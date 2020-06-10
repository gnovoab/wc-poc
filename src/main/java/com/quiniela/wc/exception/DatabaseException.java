
//Namespace
package com.quiniela.wc.exception;

/**
 * Class that represents an exception on database
 */
public class DatabaseException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * Constructor
     * @param message
     * @param cause
     */
    public DatabaseException(String message, Throwable cause) {
        super(message, cause);
    }
}