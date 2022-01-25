package lambdaintermediate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CoffeeOrder {
    private List<Coffee> coffees;
    private LocalDateTime dateTime;

    public CoffeeOrder(List<Coffee> coffees, LocalDateTime dateTime) {
        this.coffees = coffees;
        this.dateTime = dateTime;
    }
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public List<Coffee> getCoffees() {
        return new ArrayList<>(coffees);
    }
}
