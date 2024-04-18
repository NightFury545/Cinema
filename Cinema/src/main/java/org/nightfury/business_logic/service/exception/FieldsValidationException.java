package org.nightfury.business_logic.service.exception;

import java.util.List;

public class FieldsValidationException extends IllegalArgumentException {
    private final List<String> errors;

    public FieldsValidationException(List<String> errors) {
        this.errors = errors;
    }

    public List<String> getErrors() {
        return this.errors;
    }
}
