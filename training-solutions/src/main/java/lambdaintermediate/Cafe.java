package lambdaintermediate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cafe {

    private List<CoffeeOrder> coffeeOrders;

    public Cafe(List<CoffeeOrder> coffeeOrders) {
        this.coffeeOrders = coffeeOrders;
    }

    public List<Coffee> getOrderedCoffees() {
        return coffeeOrders.stream()
                .flatMap(o->o.getCoffees().stream())
                .collect(Collectors.toList());
    }

    public Integer getTotalIncome() {
        return coffeeOrders.stream()
                .flatMap(o->o.getCoffees().stream())
                .mapToInt(Coffee::getPrice)
                .sum();
    }
    public Integer getTotalIncome(LocalDate date) {
        return coffeeOrders.stream()
                .filter(o->o.getDateTime().toLocalDate().equals(date))
                .flatMap(o->o.getCoffees().stream())
                .mapToInt(Coffee::getPrice)
                .sum();
    }
    public long getNumberOfCoffee(CoffeeType type) {
        return coffeeOrders.stream()
                .flatMap(o->o.getCoffees().stream())
                .filter(c->c.getType().equals(type))
                .mapToInt(Coffee::getPrice)
                .count();
    }

    public List<CoffeeOrder> getOrdersAfter(LocalDateTime from) {
        return coffeeOrders.stream()
                .filter(o->o.getDateTime().isAfter(from))
                .collect(Collectors.toList());
    }

    public List<CoffeeOrder> getFirstFiveOrder(LocalDate date) {
        return coffeeOrders.stream()
                .filter(o->o.getDateTime().toLocalDate().equals(date))
                .sorted(Comparator.comparing(CoffeeOrder::getDateTime))
                .limit(5)
                .collect(Collectors.toList());
    }
}
