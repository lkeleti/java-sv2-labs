package harmadik_reszvizsga_potvizsga.contentsite;

import java.util.List;

public interface Content {
    boolean isPremiumContent();
    String getTitle();
    List<User> clickedBy();
    void click(User user);
}
