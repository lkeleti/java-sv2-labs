package domain;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Entity not found")
public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(Class<?> entityClass, Long id) {
        super(buildMessage(entityClass, id));
    }

    private static String buildMessage(Class<?> entityClass, Long id) {
        StringBuilder sb = new StringBuilder(entityClass.getSimpleName());
        sb.append(" with id ");
        sb.append(id);
        sb.append(" not found!");
        return sb.toString();
    }
}
