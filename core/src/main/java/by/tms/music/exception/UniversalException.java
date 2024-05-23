package by.tms.music.exception;

public class UniversalException extends RuntimeException {

    private Long id;

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
}
