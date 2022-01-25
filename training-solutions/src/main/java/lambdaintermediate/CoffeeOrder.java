package lambdaintermediate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CoffeeOrder {
    private List<Coffee> orderedCoffees;
    private LocalDateTime dateTime;

    public CoffeeOrder(List<Coffee> orderedCoffees, LocalDateTime dateTime) {
        this.orderedCoffees = orderedCoffees;
        this.dateTime = dateTime;
    }
    public LocalDateTime getDateTime() {
        return dateTime;
    }
}
