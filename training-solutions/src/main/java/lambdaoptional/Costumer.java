package lambdaoptional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class Costumer {
    private List<Costume> costumes;

    public Costumer(List<Costume> costumes) {
        this.costumes = costumes;
    }

    public List<Costume> getCostumes() {
        return new ArrayList<>(costumes);
    }

    public Optional<Costume> findFirst(Predicate<Costume> condition) {
        Costume result;
        for (Costume costume: costumes) {
            if (condition.test(costume)) {
                return Optional.of(costume);
            }
        }
        return Optional.empty();
    }

    public Optional<Costume> findFirstCostumeWithKeyWord(String keyWord)  {
        return findFirst(c->c.getDescription().contains(keyWord));
    }

    public Optional<Costume> findFirstCheaperCostume(int maxPrice) {
        return findFirst(c->c.getPrice()<maxPrice);
    }
    public Optional<Costume> findFirstCostumeSameSize(Size size) {
        return findFirst(c->c.getSize().equals(size));
    }
}
