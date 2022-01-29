package lambdacollectors.honey;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BeeKeeper {
    private List<Honey> honeys;

    public BeeKeeper(List<Honey> honeys) {
        this.honeys = honeys;
    }

    public List<Honey> getHoneys() {
        return new ArrayList<>(honeys);
    }

    public void addHoney(Honey honey) {
        honeys.add(honey);
    }

    public int getTotalValueOfGivenGlasses(GlassSize size) {
        return honeys.stream()
                .filter(h->h.getGlassSize().equals(size))
                .collect(Collectors.summingInt(h-> (int) (h.getHoneyType().getPriceByKilograms()*h.getGlassSize().getKilogramCanFitIn()))) ;
    }

    public Map<GlassSize, Long> getAmountsOfGivenType(HoneyType type) {
        return honeys.stream()
                .filter(h->h.getHoneyType().equals(type))
                .collect(Collectors.groupingBy(h->h.getGlassSize(),Collectors.counting()));
    }

    public Map<Boolean, List<Honey>> getGroupsByGivenTypeAndSize(HoneyType type, GlassSize size) {
        return honeys.stream()
                .collect(Collectors.partitioningBy(h->h.getHoneyType().equals(type) && h.getGlassSize().equals(size)));
    }
}
