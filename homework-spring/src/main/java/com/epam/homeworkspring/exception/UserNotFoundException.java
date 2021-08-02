package com.epam.homeworkspring.exception;

import com.epam.homeworkspring.model.ErrorType;

public class UserNotFoundException extends ServiceException{
    private static final String DEFAULT_MESSAGE = "User is not found!";

    public UserNotFoundException() {
        super(DEFAULT_MESSAGE);
    }

    public ErrorType getErrorType() {
        return ErrorType.DATABASE_ERROR_TYPE;
    }
}
