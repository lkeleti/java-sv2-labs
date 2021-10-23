package introexceptionreadfiletestjunit5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Recipe {
    private List<String> ingredients = new ArrayList<>();

    private List<String> readFile(Path path) {
        try {
            return Files.readAllLines(path);
        }
        catch (IOException ioe) {
            throw new IllegalArgumentException("Hiba a fájl beolvasásakor!", ioe);
        }
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void addIngredients(Path path) {
        List<String> ingredients = readFile(path);
        for (String ingredient: ingredients) {
            String[] line = ingredient.split(" ");
            if (line.length == 3) {
                this.ingredients.add(line[2]);
            }
        }
    }
}
