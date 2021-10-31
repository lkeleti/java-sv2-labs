package methodoverloading.pub;

import java.util.List;

public class ListOfGoodPubs {
    private List<Pub> goodPubs;

    public ListOfGoodPubs(List<Pub> goodPubs) {
        if (goodPubs == null || goodPubs.size() ==0) {
            throw new  IllegalArgumentException("Pub list is empty!");
        }
        this.goodPubs = goodPubs;
    }

    public Pub findTheBest() {
        Pub earliest = goodPubs.get(0);
        for (Pub pub: goodPubs) {
            if (pub.getOpenFrom().isEarlier(earliest.getOpenFrom())) {
                earliest = pub;
            }
        }
        return earliest;
    }
}
