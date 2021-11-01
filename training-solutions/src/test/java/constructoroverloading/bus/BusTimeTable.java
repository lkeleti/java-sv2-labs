package constructoroverloading.bus;

import constructoroverloading.SimpleTime;

import java.util.ArrayList;
import java.util.List;

public class BusTimeTable {

    private List<SimpleTime> timeTable = new ArrayList<>();

    public BusTimeTable(List<SimpleTime> timeTable) {
        this.timeTable = timeTable;
    }

    public BusTimeTable(int firstHour, int lastHour, int everyMinute) {
        for (int i = firstHour*60+everyMinute; i <= lastHour*60+everyMinute; i+=60){
            timeTable.add(new SimpleTime(i /60, i % 60));
        }
    }

    public List<SimpleTime> getTimeTable()
    {
        return timeTable;
    }

    public SimpleTime nextBus(SimpleTime actual)
    {
        for (SimpleTime simpleTime: timeTable){
            if ( simpleTime.difference(actual) >0){
                return simpleTime;
            }
        }
        throw new IllegalStateException("No more buses today!");
    }

    public SimpleTime getFirstBus() {
        SimpleTime firstTime = timeTable.get(0);
        for (SimpleTime time: timeTable){
            if (time.difference(firstTime) < 0){
                firstTime = time;
            }
        }
        return firstTime;
    }
}
