package controliteration.day;

public class DayMain {
    public static void main(String[] args) {
        Day day = new Day();
        for (int i = 0; i < 24; i++) {
            day.addHour(new Hour(i));
        }
        day.setDayPeriod();
        for (int i = 0; i < 24; i++) {
            System.out.print(day.getHoursOfDay().get(i).getHourNumber() + " ");
            System.out.println(day.getHoursOfDay().get(i).getPeriod().name());
        }

    }
}
