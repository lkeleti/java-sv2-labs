package lambdaintermediate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Cafe {

    private List<CoffeeOrder> coffeeOrders;

    public Cafe(List<CoffeeOrder> coffeeOrders) {
        this.coffeeOrders = coffeeOrders;
    }

    public List<Coffee> getOrderedCoffees() {

    }

    public Integer getTotalIncome() {

    }
    public Integer getTotalIncome(LocalDate date) {

    }
    public long getNumberOfCoffee(CoffeeType type) {

    }
    public List<CoffeeOrder> getOrdersAfter(LocalDateTime from) {

    }
    public List<CoffeeOrder> getFirstFiveOrder(LocalDate date) {

    }
}
