package exceptionclass.course;

public class InvalideTimeException extends RuntimeException{
    public InvalideTimeException(String message) {
        super(message);
    }

    public InvalideTimeException(String message, Throwable cause) {
        super(message, cause);
    }
}
