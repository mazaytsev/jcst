package io.github.mazaytsev.jcst.enums;

public enum FrequencyUnit {
    HERZ("hz"),
    KILOHERZ("khz"),
    MEGAHERZ("mhz"),
    GIGAHERZ("ghz"),
    TERRAHERZ("thz"),
    PENTAHERZ("phz");

    private final String frequencyUnit;

    private FrequencyUnit(String frequencyUnit) {
        this.frequencyUnit = frequencyUnit;
    }

    public String getFrequencyUnit() {
        return this.frequencyUnit;
    }
}
