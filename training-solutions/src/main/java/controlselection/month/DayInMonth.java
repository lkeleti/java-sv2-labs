package controlselection.month;

import java.util.Locale;

public class DayInMonth {
    public int numberOfDaysInMonth(int year, String month) {
        month = month.toLowerCase(Locale.ROOT);
        int result;
        switch (month) {
            case "január", "március", "május", "július", "augusztus", "október", "december":
                result = 31;
                break;
            case "április", "június", "szeptember", "november":
                result = 30;
                break;
            case "február":
                if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0){
                    result = 29;
                }
                else {
                    result = 28;
                }
                break;
            default:
                result =0;
                break;
        }
        return result;
    }
}
