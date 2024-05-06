package org.ismetg.exception;

import lombok.Getter;

@Getter
public class ExamException extends RuntimeException{
    private ErrorType errorType;

    public ExamException(ErrorType errorType) {
        super(errorType.getMessage());
        this.errorType = errorType;
    }

    public ExamException(ErrorType errorType, String customMessage) {
        super(customMessage);
        this.errorType = errorType;
    }
}
