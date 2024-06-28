package by.tms.music.exception;

import lombok.Getter;

@Getter
public class UniversalException extends RuntimeException {

    private Long id;
    private int code;
    public UniversalException(Long id) {
        super();
        this.id = id;
    }

    public UniversalException() {
        super();
    }

    public UniversalException(String message) {
        super(message);
        this.id = id;
    }
    public UniversalException(String message, int code) {
        super(message);
        this.code = code;
    }


}
