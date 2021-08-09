package com.epam.homeworkspring.exception;

import com.epam.homeworkspring.model.ErrorType;

public class UserAlreadyExistException extends ServiceException{
    private static final String DEFAULT_MESSAGE = "User already exist!";

    public UserAlreadyExistException() {
        super(DEFAULT_MESSAGE);
    }

    public ErrorType getErrorType() {
        return ErrorType.VALIDATION_ERROR_TYPE;
    }
}
