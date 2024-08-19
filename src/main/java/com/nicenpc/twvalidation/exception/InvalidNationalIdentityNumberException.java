package com.nicenpc.twvalidation.exception;

import com.nicenpc.twvalidation.validator.ErrorMessage;

public class InvalidNationalIdentityNumberException extends Throwable {

    private final ErrorMessage errorMessage;

    public InvalidNationalIdentityNumberException(ErrorMessage errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String getMessage() {
        return errorMessage.name();
    }

}
