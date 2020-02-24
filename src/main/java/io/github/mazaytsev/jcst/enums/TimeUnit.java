package io.github.mazaytsev.jcst.enums;

public enum TimeUnit {
    FEMTOSECOND("fs"),
    PICOSECOND("ps"),
    NANOSECOND("ns"),
    MICROSECOND("us"),
    MILLISECOND("ms"),
    SECOND("s");

    private final String timeUnit;

    private TimeUnit(String timeUnit) {
        this.timeUnit = timeUnit;
    }

    public String getTimeUnit() {
        return this.timeUnit;
    }
}
