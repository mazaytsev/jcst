package io.github.mazaytsev.jcst.enums;

public enum ProjectType {
    MICROWAVE("NewMWS");
//    EM("NewEMS"),
//    PARTICLE("NewPS"),
//    MPHYSICS("NewMPS"),
//    CABLE("NewCS"),
//    PCB("NewPCBS"),
//    DESIGN("NewDS");

    private final String type;

    private ProjectType(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }
}
