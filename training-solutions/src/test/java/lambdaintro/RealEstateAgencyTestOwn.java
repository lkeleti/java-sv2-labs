package lambdaintro;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class RealEstateAgencyTestOwn {
    RealEstateAgency realEstateAgency;

    @BeforeEach
    void setUp() {
        realEstateAgency = new RealEstateAgency(
                new ArrayList(Arrays.asList(
                        new Flat("Budapest",50,10_000_000),
                        new Flat("Szolnok",50,8_000_000),
                        new Flat("Budapest",60,20_000_000),
                        new Flat("Budapest",70,30_000_000),
                        new Flat("Budapest",80,40_000_000),
                        new Flat("Budapest",90,50_000_000)
                ))
        );
    }

    @Test
    void findFirstCheaperFlat() {
        assertEquals(10_000_000, realEstateAgency.findFirstCheaperFlat(20_000_000).getPrice());
    }

    @Test
    void findFirstGreaterFlat() {
        assertEquals(70, realEstateAgency.findFirstGreaterFlat(60).getArea());
    }

    @Test
    void findFirstFlatInSameTown() {
        assertEquals(10_000_000, realEstateAgency.findFirstFlatInSameTown("Budapest").getPrice());
    }
}