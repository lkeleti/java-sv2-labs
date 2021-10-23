package introexceptionreadfiletestjunit4;

import org.junit.Test;

import java.nio.file.Paths;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RecipeTest {

    @Test
    public void normalTest() {
        Recipe recipe = new Recipe();
        recipe.addIngredients(Paths.get("src/test/resources/recipe.txt"));
        assertEquals(Arrays.asList("liszt", "margarin", "kristálycukor", "tojás", "citrom", "sütőpor", "vanillincukor",
                "tejföl", "alma", "fahéj"),recipe.getIngredients());
    }

    @Test
    public void missingFileTest() {
        Recipe recipe = new Recipe();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> recipe.addIngredients(Paths.get("src/test/resources/recipe_.txt")));
        assertEquals("Hiba a fájl beolvasásakor!", exception.getMessage());
    }
}
