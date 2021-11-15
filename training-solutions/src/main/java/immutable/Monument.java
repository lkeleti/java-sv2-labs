package immutable;

import java.time.LocalDate;

public class Monument {
    private final String name;
    private final String title;
    private final LocalDate registrationDate;
    private final String registrationId;

    public Monument(String name, String title, LocalDate registrationDate, String registrationId) {
        if(isEmpty(name) || isEmpty(title) || isEmpty(registrationId)){
            throw new IllegalArgumentException("");
        }
        this.name = name;
        this.title = title;
        this.registrationDate = registrationDate;
        this.registrationId = registrationId;
    }

    private boolean isEmpty(String text) {
        return (text == null || text.trim().length() < 1);
    }
}
