package harmadik_reszvizsga_pot_potvizsga.emailservice;

import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Set;

public class EmailService {
    private Set<User> users = new LinkedHashSet<>();

    public void registerUser(String emailAddress) {
        if (validateEmail(emailAddress)) {
            if (users.stream()
                    .noneMatch(u -> u.getEmailAddress().equals(emailAddress))) {
                users.add(new User(emailAddress));
            } else {
                throw new IllegalArgumentException("Email address is already taken!");
            }
        } else {
            throw new IllegalArgumentException("Email address is not valid: " + emailAddress);
        }
    }

    private boolean validateEmail(String emailAddress) {
        return emailAddress.indexOf('@') > 1 && !emailAddress.contains("@.") && emailAddress.equals(emailAddress.toLowerCase(Locale.ROOT)) && emailAddress.indexOf('.') > 1;
    }

    public Set<User> getUsers() {
        return new LinkedHashSet<>(users);
    }

    public void sendEmail(String from, String to, String subject, String content) {
        users.stream()
                .filter(u -> u.getEmailAddress().equals(from))
                .findFirst().orElseThrow(() -> new IllegalArgumentException("Invalid sender!"))
                .sendEmail(subject, content, users.stream().
                        filter(u -> u.getEmailAddress().equals(to))
                        .findFirst().orElseThrow(() -> new IllegalArgumentException("Invalid mailing address")));
    }

    public void sendSpam(String subject, String content) {
        for (User user : users) {
            user.getEmail(new Spam(user,subject, content));
        }
    }
}
