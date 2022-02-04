package harmadik_reszvizsga_pot_potvizsga.emailservice;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class User {
    private String emailAddress;
    private List<Email> incoming = new ArrayList<>();
    private List<Email> sent = new ArrayList<>();
    private boolean spamFilter;

    public User(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public List<Email> getIncoming() {
        return new ArrayList<>(incoming).stream()
                .sorted(Comparator.comparing(Email::isImportant).reversed())
                .toList();
    }

    public List<Email> getSent() {
        return new ArrayList<>(sent).stream()
                .sorted(Comparator.comparing(Email::isImportant).reversed())
                .toList();
    }

    public boolean hasSpamFilter() {
        return spamFilter;
    }

    public void spamFilterChange() {
        spamFilter = !spamFilter;
    }

    public void getEmail(Email email) {
        if (hasSpamFilter() && email.getFrom().emailAddress.contains("spam")) {
            throw new IllegalStateException("Be careful, tis is a spam!");
        }
        else {
            incoming.add(email);
        }
    }

    public void sendEmail(String subject, String content, User to) {
        Email email = new Normal(this, to, subject, content);
        sent.add(email);
        to.getEmail(email);
    }
}
