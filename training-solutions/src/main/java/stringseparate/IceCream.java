package stringseparate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IceCream {
    private List<String> iceCreams = new ArrayList<>(Arrays.asList("csoki", "vanília", "eper", "citrom", "puncs",
            "pisztácia", "feketeerdő", "málna", "sztracsatella"));

    public List<String> getIceCreams() {
        return iceCreams;
    }

    public static void main(String[] args) {
        IceCream iceCream = new IceCream();

        StringBuilder offer = new StringBuilder();
        offer.append("Ma kapható: ");

        for (int i = 0; i < iceCream.getIceCreams().size(); i++) {
            offer.append(iceCream.getIceCreams().get(i));
            if (i == iceCream.getIceCreams().size()-1) {
                offer.append(".");
            }
            else
            {
                offer.append(", ");
            }
        }
        offer.append(" Gyerekeknek féláron!");
        System.out.println(offer);
    }
}
