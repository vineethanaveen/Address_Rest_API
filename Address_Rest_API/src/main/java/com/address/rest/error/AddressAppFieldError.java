package com.address.rest.error;

/**
 * 
 * Manage field errors
 *
 */
public class    AddressAppFieldError {

    private final String field;

    private final String message;

    AddressAppFieldError(String field, String message) {
        this.field = field;
        this.message = message;
    }

    public String getField() {
        return field;
    }

    public String getMessage() {
        return message;
    }


}
