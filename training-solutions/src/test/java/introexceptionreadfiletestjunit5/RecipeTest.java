package introexceptionreadfiletestjunit5;

import org.junit.jupiter.api.Test;

import java.nio.file.Paths;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RecipeTest {

    @Test
    void normalTest() {
        Recipe recipe = new Recipe();
        recipe.addIngredients(Paths.get("src/test/resources/recipe.txt"));
        assertEquals(Arrays.asList("liszt", "margarin", "kristálycukor", "tojás", "citrom", "sütőpor", "vanillincukor",
                "tejföl", "alma", "fahéj"), recipe.getIngredients());
    }

    @Test
    void missingFileTest() {
        Recipe recipe = new Recipe();
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class,
                () -> recipe.addIngredients(Paths.get("src/test/resources/recipe_.txt")));
        assertEquals("Hiba a fájl beolvasásakor!",illegalArgumentException.getMessage());
    }
}
