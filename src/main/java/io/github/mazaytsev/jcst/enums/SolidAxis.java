package io.github.mazaytsev.jcst.enums;

public enum SolidAxis {
    X("x"),
    Y("y"),
    Z("z");

    private final String axis;

    private SolidAxis(String axis) {
        this.axis = axis;
    }

    public String getAxis() {
        return this.axis;
    }
}
