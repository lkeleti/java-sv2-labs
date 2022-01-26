package lambdaprimitives;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;

public class Truck {
    private List<Cargo> listOfCargos;

    public Truck(List<Cargo> listOfCargos) {
        this.listOfCargos = listOfCargos;
    }

    public List<Cargo> getListOfCargos() {
        return new ArrayList<>(listOfCargos);
    }

    public double getShortestLength() {
        return listOfCargos.stream()
                .mapToDouble(Cargo::getLength)
                .min()
                .orElse(0.0);
    }

    public int getTotalWeight() {
        return listOfCargos.stream()
                .mapToInt(Cargo::getWeight)
                .sum();
    }

    public double getAverageWeight() {
        return listOfCargos.stream()
                .mapToDouble(Cargo::getWeight)
                .average()
                .orElseThrow(()-> new IllegalArgumentException("No cargo."));
    }

    public int getMaxWeight() {
        return listOfCargos.stream()
                .mapToInt(Cargo::getWeight)
                .max()
                .orElse(0);
    }

    public String getWeightStatistics() {
        IntSummaryStatistics result = listOfCargos.stream()
                .mapToInt(Cargo::getWeight)
                .summaryStatistics();
        if (result.getCount() == 0) {
            return "No cargo.";
        }
        else {
            return String.format("A rakományban található %d tétel, melyeknek összsúlya %d kg, közülük a legnehezebb %d kg, a legkönnyebb %d kg. A súlyuk átlagosan %.1f kg.",
                    result.getCount(), result.getSum(), result.getMax(), result.getMin(), result.getAverage());
        }
    }
}
