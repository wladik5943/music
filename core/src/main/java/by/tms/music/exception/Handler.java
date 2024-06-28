package by.tms.music.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Slf4j
public class Handler {

    @ExceptionHandler
    @ResponseBody
    public ExceptionResponse universalException(final UniversalException e) {
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setMessage(e.getMessage());
        exceptionResponse.setCode(e.getCode());
        exceptionResponse.setStatus(HttpStatus.BAD_REQUEST);
        return exceptionResponse;
    }
}
