package defaultconstructor.date;

public class SimpleDate {
    private int year;
    private int month;
    private int day;

    public void setDate(int year, int month, int day) {
        if (!isCorrect(year, month, day)) {
            throw new IllegalArgumentException("One or more given parameter cannot be applied! " + year + ", " + month + ", " + day);
        }
        this.year = year;
        this.month = month;
        this.day = day;
    }

    private boolean isCorrect(int year, int month, int day) {
        if (year < 1900 || month < 1 || month >12 || day < 1 || day > 31) {
            return false;
        }
        return (day <= calculateMonthLength(year,month));
    }

    private int calculateMonthLength(int year, int month){
        switch (month) {
            case 4,6,9,11:
                return 30;
            case 1,3,5,7,8,10,12:
                return 31;
            default:
                if (isLeapYear(year)) {
                    return 29;
                }
                else {
                    return 28;
                }
        }

    }

    private boolean isLeapYear(int year){
        return (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0));
    }

    public int getYear(){
        return year;
    }

    public int getMonth() {
        return month;
    }
    public int getDay() {
        return day;
    }
}
