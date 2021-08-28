package com.epam.homeworkspring.exception;

import com.epam.homeworkspring.model.ErrorType;

public class PasswordNotValidException extends ServiceException{
    private static final String DEFAULT_MESSAGE = "Password is nor valid";

    public PasswordNotValidException () {
        super(DEFAULT_MESSAGE);
    }

    public ErrorType getErrorType() {
        return ErrorType.VALIDATION_ERROR_TYPE;
    }
}
