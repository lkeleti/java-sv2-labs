package lambdacollectors.christmastree;

import javax.swing.*;
import java.util.*;
import java.util.stream.Collectors;

public class ChristmasTreeFair {

    private List<ChristmasTree> christmasTrees;

    public ChristmasTreeFair(List<ChristmasTree> christmasTrees) {
        this.christmasTrees = christmasTrees;
    }

    public List<ChristmasTree> getChristmasTrees() {
        return new ArrayList<>(christmasTrees);
    }

    public Map<PineTreeType, Long> getCountByType() {
        return christmasTrees.stream()
                .collect(Collectors.groupingBy(
                        t->t.getType(),Collectors.counting()
                ));
    }

    public double getMaxHeightByType(PineTreeType type) {
//        return christmasTrees.stream()
//                .filter(t->t.getType().equals(type))
//                .mapToDouble(t->t.getHeight())
//                .max()
//                .orElse(0.0);
        return christmasTrees.stream()
                .filter(t->t.getType().equals(type))
                .collect(Collectors.maxBy(Comparator.comparingDouble(ChristmasTree::getHeight)))
                .map(ChristmasTree::getHeight).orElse(0.0);

    }
    public double getAveragePrice() {
        return christmasTrees.stream()
                .collect(Collectors.averagingDouble(t->(t.getType().getPricePerMeter())*(t.getHeight())));
    }
}
