package com.address.rest.error;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class    AddressAppValidationError {

    private final List<AddressAppFieldError> fieldErrors = new ArrayList<>();

    public AddressAppValidationError() {

    }

    public void addFieldError(String path, String message) {
        AddressAppFieldError error = new AddressAppFieldError(path, message);
        fieldErrors.add(error);
    }

    public List<AddressAppFieldError> getFieldErrors() {
        return Collections.unmodifiableList(fieldErrors);
    }
}
