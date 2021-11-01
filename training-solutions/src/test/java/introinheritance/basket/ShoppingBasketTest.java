package introinheritance.basket;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShoppingBasketTest {

    private ShoppingBasket shoppingBasket;

    @BeforeEach
    void setUp() {
        shoppingBasket = new ShoppingBasket();
        shoppingBasket.addItem(new Item("123456", 1500, 27));
        shoppingBasket.addItem(new Item("789456", 2500, 0));
        shoppingBasket.addItem(new Item("147258", 5000, 27));
    }

    @AfterEach
    void tearDown() {
        shoppingBasket = null;
    }

    @Test
    void testAddItem() {
        assertEquals(9000L, Math.round(shoppingBasket.sumNettoPrice()));
    }

    @Test
    void testRemoveItem() {
        // When
        shoppingBasket.removeItem("123456");
        //Then
        assertEquals(7500L, Math.round(shoppingBasket.sumNettoPrice()));
    }

    @Test
    void testSumNettoPrice() {

        assertEquals(9000.0, shoppingBasket.sumNettoPrice());
    }

    @Test
    void testSumTaxValue() {

        assertEquals(1755.0, shoppingBasket.sumTaxValue());
    }

    @Test
    void testSumBruttoPrice() {

        assertEquals(10755.0, shoppingBasket.sumBruttoPrice());
    }

    @Test
    void testCheckout() {
        //When
        shoppingBasket.checkout();
        //Then
        assertEquals(0.0, shoppingBasket.sumNettoPrice());
    }

    @Test
    void testRemoveMostExpensiveItem() {
        // When
        shoppingBasket.removeMostExpensiveItem();
        //Then
        assertEquals(4000.0, shoppingBasket.sumNettoPrice());
    }
}
