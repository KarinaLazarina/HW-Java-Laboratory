package com.epam.homeworkspring.exception;

import com.epam.homeworkspring.model.ErrorType;

public class GroupNotFoundException  extends ServiceException{
    private static final String DEFAULT_MESSAGE = "Group is not found!";

    public GroupNotFoundException () {
        super(DEFAULT_MESSAGE);
    }

    public ErrorType getErrorType() {
        return ErrorType.DATABASE_ERROR_TYPE;
    }
}

