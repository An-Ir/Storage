package com.example.storage.infrastructure.validation;

import lombok.Getter;

@Getter
public enum Error {
    INCORRECT_CREDENTIALS("Vale kasutajanimi või parool", 111),
    CONFLICTING_CREDENTIALS("Sellise e-maili aadressiga kasutaja on juba olemas", 112),
    NO_LOCATION_FOUND("Ei leitud ühtegi rendipinda", 222),
    LOCATION_UNAVAILABLE("Sellise nimega asukoht on juba olemas", 333);

    private final String message;
    private final int errorCode;

    Error(String message, int errorCode) {
        this.message = message;
        this.errorCode = errorCode;
    }
}
