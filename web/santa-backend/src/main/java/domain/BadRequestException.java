package domain;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST, reason="Invalid Data")
public class BadRequestException extends RuntimeException {

    public BadRequestException(String message) {
        super(message);
    }
}
