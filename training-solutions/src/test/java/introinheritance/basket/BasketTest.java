package introinheritance.basket;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BasketTest {

    private Basket basket;

    @BeforeEach
    void setUp() {
        basket = new Basket();
        basket.addItem(new Item("457812", 1500, 27));
        basket.addItem(new Item("654789", 2500, 0));
    }

    @AfterEach
    void tearDown() {
        basket = null;
    }

    @Test
    void testAddItem() {
        assertEquals(2, basket.getItems().size());
    }

    @Test
    void testRemoveItem() {
        //When
        basket.removeItem("457812");
        //Then
        assertEquals(1, basket.getItems().size());
    }

    @Test
    void testClearBasket() {
        //When
        basket.clearBasket();
        //Then
        assertEquals(0, basket.getItems().size());
    }
}
