package controlselection.month;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DayInMonthTest {

    @Test
    void dayInMonthTest() {
        DayInMonth dayInMonth = new DayInMonth();

        int days = dayInMonth.numberOfDaysInMonth(2021, "Február");
        assertEquals(28,days);

        days = dayInMonth.numberOfDaysInMonth(2021, "Január");
        assertEquals(31,days);

        days = dayInMonth.numberOfDaysInMonth(2021, "ÁpriLIs");
        assertEquals(30,days);

        days = dayInMonth.numberOfDaysInMonth(2020, "FebRuár");
        assertEquals(29,days);

        days = dayInMonth.numberOfDaysInMonth(2100, "Február");
        assertEquals(28,days);
    }
}
