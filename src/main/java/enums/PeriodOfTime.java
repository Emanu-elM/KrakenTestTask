package enums;

public enum PeriodOfTime {
    H24("24H"),
    W1("1W"),
    M1("1M"),
    Y1("1Y"),
    Y5("5Y");

    private final String value;

    PeriodOfTime(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }


}
