package io.github.mazaytsev.jcst.enums;

public enum TemperatureUnit {
    CELCIUS("celsius"),
    KELVIN("kelvin"),
    FAHRENHEIT("fahrenheit");

    private final String temperatureUnit;

    private TemperatureUnit(String temperatureUnit) {
        this.temperatureUnit = temperatureUnit;
    }

    public String getTemperatureUnit() {
        return this.temperatureUnit;
    }
}
