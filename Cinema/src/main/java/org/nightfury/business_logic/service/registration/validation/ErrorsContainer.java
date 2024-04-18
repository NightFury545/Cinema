package org.nightfury.business_logic.service.registration.validation;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

@Getter
public class ErrorsContainer {
    private final List<String> errors = new ArrayList<>();

    public void addError(String error) {
        errors.add(error);
    }

    public void clearErrors() {
        errors.clear();
    }

}
