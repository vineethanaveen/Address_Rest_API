package com.address.rest.util;

/**
 * Utility methods for validation
 *
 
 */
public class    AddressValidationUtil {
//    /**
//     *;
//    }
    /**
     * checks whether given string length exceeds allowable length
     */
    public static void checkStringLength(String string,int allowedStringLength, String errorMessage) {
        if (string.length()>allowedStringLength	) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
    /**
     * Ensures that the string given as a method parameter is not empty.
     * 
     */
    public static void notEmpty(String string, String errorMessage) {
        if (string.isEmpty()) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
    /**
     * Ensures that the object given as a method parameter is not null.
     * 
     */
    public static void notNull(Object reference, String errorMessage) {
        if (reference == null) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
