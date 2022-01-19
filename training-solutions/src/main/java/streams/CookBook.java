package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CookBook {
    private List<Cake> cakes = new ArrayList<>();

    public CookBook(List<Cake> cakes) {
        this.cakes = cakes;
    }

    public void addCake(Cake cake) {
        cakes.add(cake);
    }

    public List<Cake> getCakes() {
        return new ArrayList<>(cakes);
    }

    public List<String> listCakeNamesWithGivenIngredient(String ingredient) {
        return cakes.stream().
                filter(cake->cake.getIngredients().contains(ingredient)).
                map(cake->cake.getName()).
                collect(Collectors.toList());
    }

    public List<String> listCakeNamesWithMaxIngredients(int max) {
        return cakes.stream().
                filter(cake->cake.getIngredients().size() <= max).
                map(cake->cake.getName()).
                collect(Collectors.toList());
    }
}
