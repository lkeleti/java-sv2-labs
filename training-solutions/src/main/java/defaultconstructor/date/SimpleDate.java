package defaultconstructor.date;

public class SimpleDate {
    private int year;
    private int month;
    private int day;

    public void setDate(int year, int month, int day) {
        if (!checkDate(year, month, day)) {
            throw new IllegalArgumentException("One or more given parameter cannot be applied! " + year + ", " + month + ", " + day);
        }
        this.year = year;
        this.month = month;
        this.day = day;
    }

    private boolean checkDate(int year, int month, int day) {
        if (year < 1900 || month < 1 || month >12 || day < 1 || day > 31) {
            return false;
        }
        if (month == 2) {
            if (!(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) && day == 29){
                return false;
            }
        }
        switch (month) {
            case 4:
            case 6:
            case 9:
            case 11:
                if (day == 31) {
                    return false;
                }
                break;
        }
        return true;
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
