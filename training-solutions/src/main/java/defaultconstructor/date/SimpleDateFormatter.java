package defaultconstructor.date;

public class SimpleDateFormatter {

    private CountryCode defaultCountryCode;

    public SimpleDateFormatter() {
        defaultCountryCode = CountryCode.HU;
    }

    public CountryCode getDefaultCountryCode() {
        return defaultCountryCode;
    }

    public void setDefaultCountryCode(CountryCode defaultCountryCode) {
        this.defaultCountryCode = defaultCountryCode;
    }

    public String formatDateString(SimpleDate simpleDate) {
        return formatDate(defaultCountryCode,simpleDate);
    }

    public String formatDateStringByCountryCode(CountryCode countryCode, SimpleDate simpleDate) {
        return formatDate(countryCode, simpleDate);
    }

    private String formatDate(CountryCode countryCode, SimpleDate simpleDate) {
        switch (countryCode) {
            case EN -> {
                return simpleDate.getDay() + "-" + simpleDate.getMonth() + "-"  + simpleDate.getYear();
            }
            case HU -> {
                return simpleDate.getYear() + "-" + simpleDate.getMonth() + "-"  + simpleDate.getDay();
            }
            default -> {
                return simpleDate.getMonth() + "-" + simpleDate.getDay() + "-"  + simpleDate.getYear();
            }
        }
    }
}
