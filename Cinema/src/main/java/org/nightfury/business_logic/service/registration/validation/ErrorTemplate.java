package org.nightfury.business_logic.service.registration.validation;

public enum ErrorTemplate {

    MIN_LENGTH("Довжина поля %s має бути не меншою за %d символів!"),
    MAX_LENGTH("Довжина поля %s має бути не більшою за %d символів!"),
    ONLY_LATIN("Поле %s має містити тільки латинські символи та цифри!");

    private String template;

    ErrorTemplate(String template) {
        this.template = template;
    }

    public String getTemplate() {
        return this.template;
    }
}
