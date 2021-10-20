package controlselection.greetings;

import java.time.LocalTime;

public class Greetings {
    private final LocalTime MORNING_TIME = LocalTime.of(5,0);
    private final LocalTime DAY_TIME = LocalTime.of(9,0);
    private final LocalTime AFTERNOON_TIME = LocalTime.of(18,30);
    private final LocalTime NIGHT_TIME = LocalTime.of(20,00);

    public String greetingByTime(int hour, int minute) {
        LocalTime actualTime = LocalTime.of(hour, minute);
        String result = null;
        if (actualTime.isAfter(MORNING_TIME) && actualTime.isBefore(DAY_TIME)) {
            result = "Jó reggelt!";
        }
        else {
            if (actualTime.isAfter(DAY_TIME) && actualTime.isBefore(AFTERNOON_TIME)) {
                result = "Jó napot!";
            }
            else {
                if (actualTime.isAfter(AFTERNOON_TIME) && actualTime.isBefore(NIGHT_TIME)) {
                    result = "Jó estét!";
                }
                else {
                    result = "Jó éjt!";
                }
            }
        }
        return result;
    }
}
