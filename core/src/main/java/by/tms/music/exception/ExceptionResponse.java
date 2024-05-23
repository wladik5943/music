package by.tms.music.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Setter
@Getter
public class ExceptionResponse {

    private HttpStatus status;
    private Integer statusInt;
    private String message;

}
