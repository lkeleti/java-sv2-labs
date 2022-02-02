package harmadik_reszvizsga_potvizsga.contentsite;

import java.util.*;

public class ContentService {
    private Set<User> users = new LinkedHashSet<>();
    private Set<Content> contents = new LinkedHashSet<>();

    public void registerUser(String name, String password) {
        if (users.stream().noneMatch(u->u.getUserName().equals(name))) {
            users.add(new User(name,password));
        }
        else {
            throw new IllegalArgumentException("Username is already taken: "+ name);
        }
    }

    public void addContent(Content content) {
        if (contents.stream().noneMatch(c->c.getTitle().equals(content.getTitle()))) {
            contents.add(content);
        }
        else {
            throw new IllegalArgumentException("Content name is already taken: " + content.getTitle());
        }
    }

    public void logIn(String username, String password) {
        int hashedCredientals = (username+password).hashCode();
        User actualUser = users.stream().filter(u->u.getUserName().equals(username)).findFirst().orElseThrow(
                ()-> new IllegalArgumentException("Username is wrong!")
        );
        if (actualUser.getPassword() != hashedCredientals) {
            throw new IllegalArgumentException("Password is Invalid!");
        }

        actualUser.setLogIn(true);
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(users);
    }

    public List<Content> getAllContent() {
        return new ArrayList<>(contents);
    }
}
