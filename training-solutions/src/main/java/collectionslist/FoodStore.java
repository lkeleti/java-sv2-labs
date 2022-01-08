package collectionslist;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class FoodStore {
    private LinkedList<Food> foods = new LinkedList<>();

    public List<Food> getFoods() {
        return new LinkedList<>(foods);
    }

    public void addFood(Food food) {
        foods.add(food);
    }
    public void sellFirst(Food food) {
        if (food.getExpirationDate().isEqual(LocalDate.now())) {
            foods.add(0,food);
        }
    }
}
