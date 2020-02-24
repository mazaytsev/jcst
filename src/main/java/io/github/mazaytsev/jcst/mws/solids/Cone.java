package io.github.mazaytsev.jcst.mws.solids;

import com.jacob.com.Dispatch;
import io.github.mazaytsev.jcst.ProjectInstance;
import io.github.mazaytsev.jcst.enums.SolidAxis;
import io.github.mazaytsev.jcst.utils.Tuple;

public class Cone {
    private boolean reset;
    private String material;
    private String name;
    private String component;
    private SolidAxis axis;
    private double topRadius;
    private double bottomRadius;
    private double xcenter;
    private double ycenter;
    private double zcenter;
    private Tuple<Double, Double> xrange;
    private Tuple<Double, Double> yrange;
    private Tuple<Double, Double> zrange;
    private int segments;
    private ProjectInstance projectInstance;

    private Cone(Builder build) {
        this.reset = build.nestedReset;
        this.material = build.nestedMaterial;
        this.name = build.nestedName;
        this.component = build.nestedComponent;
        this.axis = build.nestedAxis;
        this.topRadius = build.nestedTopRadius;
        this.bottomRadius = build.nestedBottomRadius;
        this.xcenter = build.nestedXcenter;
        this.ycenter = build.nestedYcenter;
        this.zcenter = build.nestedZcenter;
        this.xrange = build.nestedXrange;
        this.yrange = build.nestedYrange;
        this.zrange = build.nestedZrange;
        this.segments = build.nestedSegments;
        this.projectInstance = build.nestedProjectInstance;
        execute();
    }

    private void execute() {
        if (projectInstance == null) {
            return;
        }
        Dispatch cone = Dispatch.call(projectInstance.getDocument(), "Cone").toDispatch();
        if (reset) {
            Dispatch.call(cone, "Reset");
        }
        if (name != null) {
            Dispatch.call(cone, "Name", name);
        }
        if (component != null) {
            Dispatch.call(cone, "Component", component);
        }
        if (material != null) {
            Dispatch.call(cone, "Material", material);
        }
        if (axis != null) {
            Dispatch.call(cone, "Axis", axis.getAxis());
        }
        if (topRadius != 0) {
            Dispatch.call(cone, "TopRadius", topRadius);
        }
        if (bottomRadius != 0) {
            Dispatch.call(cone, "BottomRadius", bottomRadius);
        }
        if (xcenter != 0) {
            Dispatch.call(cone, "Xcenter", xcenter);
        }
        if (ycenter != 0) {
            Dispatch.call(cone, "Ycenter", ycenter);
        }
        if (zcenter != 0) {
            Dispatch.call(cone, "Zcenter", zcenter);
        }
        if (xrange != null) {
            Dispatch.call(cone, "Xrange", xrange.getX(), xrange.getY());
        }
        if (yrange != null) {
            Dispatch.call(cone, "Yrange", yrange.getX(), yrange.getY());
        }
        if (zrange != null) {
            Dispatch.call(cone, "Zrange", zrange.getX(), zrange.getY());
        }
        if (segments != 0) {
            Dispatch.call(cone, "Segments", segments);
        }
        Dispatch.call(cone, "Create");

    }

    public static class Builder {
        private boolean nestedReset = false;
        private String nestedMaterial;
        private String nestedName;
        private String nestedComponent;
        private SolidAxis nestedAxis;
        private double nestedTopRadius;
        private double nestedBottomRadius;
        private double nestedXcenter;
        private double nestedYcenter;
        private double nestedZcenter;
        private Tuple<Double, Double> nestedXrange;
        private Tuple<Double, Double> nestedYrange;
        private Tuple<Double, Double> nestedZrange;
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

        public Builder bottomRadius(double bottomRadius) {
            this.nestedBottomRadius = bottomRadius;
            return this;
        }

        public Builder xcenter(double xcenter) {
            this.nestedXcenter = xcenter;
            return this;
        }

        public Builder ycenter(double ycenter) {
            this.nestedYcenter = ycenter;
            return this;
        }

        public Builder zcenter(double zcenter) {
            this.nestedZcenter = zcenter;
            return this;
        }

        public Builder xrange(double x, double y) {
            this.nestedXrange = new Tuple<Double, Double>(x, y);
            return this;
        }

        public Builder yrange(double x, double y) {
            this.nestedYrange = new Tuple<Double, Double>(x, y);
            return this;
        }

        public Builder zrange(double x, double y) {
            this.nestedZrange = new Tuple<Double, Double>(x, y);
            return this;
        }

        public Builder segments(int segments) {
            this.nestedSegments = segments;
            return this;
        }

        public Cone build() {
            return new Cone(this);
        }
    }
}
