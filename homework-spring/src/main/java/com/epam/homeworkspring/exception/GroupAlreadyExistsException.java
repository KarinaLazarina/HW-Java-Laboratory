package com.epam.homeworkspring.exception;

import com.epam.homeworkspring.model.ErrorType;

public class GroupAlreadyExistsException extends ServiceException{
    private static final String DEFAULT_MESSAGE = "Group already exists!";

    public  GroupAlreadyExistsException() {
        super(DEFAULT_MESSAGE);
    }

    public ErrorType getErrorType() {
        return ErrorType.VALIDATION_ERROR_TYPE;
    }
}
