package controlselection.week;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DayOfWeeksTest {

    @Test
    void whichPartOfWeekTest() {
        DayOfWeeks dayOfWeeks = new DayOfWeeks();

        String result = dayOfWeeks.partOfTheWeek("Hétfő");
        assertEquals("hét eleje", result);

        result = dayOfWeeks.partOfTheWeek("KEDD");
        assertEquals("hét közepe", result);

        result = dayOfWeeks.partOfTheWeek("SzerdA");
        assertEquals("hét közepe", result);

        result = dayOfWeeks.partOfTheWeek("csütörtök");
        assertEquals("hét közepe", result);

        result = dayOfWeeks.partOfTheWeek("pénTEK");
        assertEquals("majdnem hétvége", result);

        result = dayOfWeeks.partOfTheWeek("SZOMBAT");
        assertEquals("hét vége", result);

        result = dayOfWeeks.partOfTheWeek("Vasárnap");
        assertEquals("hét vége", result);

        result = dayOfWeeks.partOfTheWeek("Harmadik pihenőnap");
        assertEquals("ismeretlen nap", result);
    }

}
