package io.github.mazaytsev.jcst.enums;

public enum GeometryUnit {
    METER("m"),
    CENTIMETER("cm"),
    MILLIMETER("mm"),
    MICROMETER("um"),
    NANOMETER("nm"),
    FEET("ft"),
    INCH("in"),
    THOU("mil");

    private final String geomteryUnit;

    private GeometryUnit(String geomteryUnit) {
        this.geomteryUnit = geomteryUnit;
    }

    public String getGeomteryUnit() {
        return this.geomteryUnit;
    }
}
