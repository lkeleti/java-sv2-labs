package lambdaintro;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class UsedCarsTest {
    UsedCars usedCars;

    @BeforeEach
    void setUp() {
        usedCars = new UsedCars(
                new ArrayList(Arrays.asList(
                        new Car("Lada", "Niva", 100_000,2.0),
                        new Car("Lada", "Samara", 90_000,1.8),
                        new Car("Suzuki", "Swift", 300_000,2.0),
                        new Car("Suzuki", "Vitara", 100_000,2.1),
                        new Car("Suzuki", "SX4", 400_000,2.5),
                        new Car("Suzuki", "Ignis", 100_000,1.5)
                ))
        );
    }

    @Test
    void listCarsByPrice() {
        assertEquals(90000, usedCars.listCarsByPrice().get(0).getPrice());
    }

    @Test
    void listCarsByLengthDesc() {
        assertEquals(2.5, usedCars.listCarsByLengthDesc().get(0).getLength());
    }

    @Test
    void listCarsOneBrandByType() {
        assertEquals("Ignis", usedCars.listCarsOneBrandByType("Suzuki").get(0).getTypeOfCar());
    }
}