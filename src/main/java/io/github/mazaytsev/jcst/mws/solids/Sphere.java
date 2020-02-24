package io.github.mazaytsev.jcst.mws.solids;

import com.jacob.com.Dispatch;
import io.github.mazaytsev.jcst.ProjectInstance;
import io.github.mazaytsev.jcst.enums.SolidAxis;
import io.github.mazaytsev.jcst.utils.Tuple;

public class Sphere {
    private boolean reset;
    private String material;
    private String name;
    private String component;
    private SolidAxis axis;
    private double topRadius;
    private double centerRadius;
    private double bottomRadius;
    private Tuple<Double, Tuple<Double,Double>> center;
    private int segments;
    private ProjectInstance projectInstance;

    private Sphere(Builder build) {
        this.reset = build.nestedReset;
        this.material = build.nestedMaterial;
        this.name = build.nestedName;
        this.component = build.nestedComponent;
        this.axis = build.nestedAxis;
        this.topRadius = build.nestedTopRadius;
        this.centerRadius=build.nestedCenterRadius;
        this.bottomRadius = build.nestedBottomRadius;
        this.center=build.center;
        this.segments = build.nestedSegments;
        this.projectInstance = build.nestedProjectInstance;
        execute();
    }

    private void execute(){
        if (projectInstance == null) {
            return;
        }
        Dispatch sphere = Dispatch.call(projectInstance.getDocument(), "Sphere").toDispatch();
        if (reset) {
            Dispatch.call(sphere, "Reset");
        }
        if (name != null) {
            Dispatch.call(sphere, "Name", name);
        }
        if (component != null) {
            Dispatch.call(sphere, "Component", component);
        }
        if (material != null) {
            Dispatch.call(sphere, "Material", material);
        }
        if (axis != null) {
            Dispatch.call(sphere, "Axis", axis.getAxis());
        }
        if (topRadius != 0) {
            Dispatch.call(sphere, "TopRadius", topRadius);
        }
        if (centerRadius != 0) {
            Dispatch.call(sphere, "CenterRadius", topRadius);
        }
        if (bottomRadius != 0) {
            Dispatch.call(sphere, "BottomRadius", bottomRadius);
        }
        if (segments != 0) {
            Dispatch.call(sphere, "Center", center.getX(), center.getY().getX(), center.getY().getY());
        }
        if (segments != 0) {
            Dispatch.call(sphere, "Segments", segments);
        }
        Dispatch.call(sphere, "Create");

    }

    public static class Builder {
        private boolean nestedReset = false;
        private String nestedMaterial;
        private String nestedName;
        private String nestedComponent;
        private SolidAxis nestedAxis;
        private double nestedTopRadius;
        private double nestedCenterRadius;
        private double nestedBottomRadius;
        private Tuple<Double, Tuple<Double,Double>> center;
        private int nestedSegments;
        private ProjectInstance nestedProjectInstance;

        public Builder(ProjectInstance projectInstance, String name) {
            this.nestedProjectInstance = projectInstance;
            this.nestedName = name;
        }

        public Builder reset() {
            this.nestedReset = true;
            return this;
        }

        public Builder material(String material) {
            this.nestedMaterial = material;
            return this;
        }

        public Builder component(String component) {
            this.nestedComponent = component;
            return this;
        }

        public Builder axis(SolidAxis axis) {
            this.nestedAxis = axis;
            return this;
        }

        public Builder topRadius(double topRadius) {
            this.nestedTopRadius = topRadius;
            return this;
        }

        public Builder centerRadius(double centerRadius) {
            this.nestedCenterRadius = centerRadius;
            return this;
        }

        public Builder bottomRadius(double bottomRadius) {
            this.nestedBottomRadius = bottomRadius;
            return this;
        }

        public Builder center(double x, double y, double z) {
            this.center=new Tuple<Double, Tuple<Double, Double>>(x,new Tuple<Double, Double>(y,z));
            return this;
        }

        public Builder segments(int segments) {
            this.nestedSegments = segments;
            return this;
        }

        public Sphere build() {
            return new Sphere(this);
        }
    }
}
