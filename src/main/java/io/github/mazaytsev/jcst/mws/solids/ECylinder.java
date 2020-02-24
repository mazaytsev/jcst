package io.github.mazaytsev.jcst.mws.solids;

import com.jacob.com.Dispatch;
import io.github.mazaytsev.jcst.ProjectInstance;
import io.github.mazaytsev.jcst.enums.SolidAxis;
import io.github.mazaytsev.jcst.utils.Tuple;

public class ECylinder {
    private boolean reset;
    private String material;
    private String name;
    private String component;
    private SolidAxis axis;
    private double xradius;
    private double yradius;
    private double zradius;
    private double xcenter;
    private double ycenter;
    private double zcenter;
    private Tuple<Double, Double> xrange;
    private Tuple<Double, Double> yrange;
    private Tuple<Double, Double> zrange;
    private int segments;
    private ProjectInstance projectInstance;

    private ECylinder(Builder build) {
        this.reset = build.nestedReset;
        this.material = build.nestedMaterial;
        this.name = build.nestedName;
        this.component = build.nestedComponent;
        this.axis = build.nestedAxis;
        this.xradius = build.nestedXradius;
        this.yradius = build.nestedYradius;
        this.zradius = build.nestedZradius;
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
        Dispatch eCylinder = Dispatch.call(projectInstance.getDocument(), "ECylinder").toDispatch();
        if (reset) {
            Dispatch.call(eCylinder, "Reset");
        }
        if (name != null) {
            Dispatch.call(eCylinder, "Name", name);
        }
        if (component != null) {
            Dispatch.call(eCylinder, "Component", component);
        }
        if (material != null) {
            Dispatch.call(eCylinder, "Material", material);
        }
        if (axis != null) {
            Dispatch.call(eCylinder, "Axis", axis.getAxis());
        }
        if (xradius != 0) {
            Dispatch.call(eCylinder, "Xradius", xradius);
        }
        if (yradius != 0) {
            Dispatch.call(eCylinder, "Yradius", yradius);
        }
        if (zradius != 0) {
            Dispatch.call(eCylinder, "Zradius", zradius);
        }
        if (xcenter != 0) {
            Dispatch.call(eCylinder, "Xcenter", xcenter);
        }
        if (ycenter != 0) {
            Dispatch.call(eCylinder, "Ycenter", ycenter);
        }
        if (zcenter != 0) {
            Dispatch.call(eCylinder, "Zcenter", zcenter);
        }
        if (xrange != null) {
            Dispatch.call(eCylinder, "Xrange", xrange.getX(), xrange.getY());
        }
        if (yrange != null) {
            Dispatch.call(eCylinder, "Yrange", yrange.getX(), yrange.getY());
        }
        if (zrange != null) {
            Dispatch.call(eCylinder, "Zrange", zrange.getX(), zrange.getY());
        }
        if (segments != 0) {
            Dispatch.call(eCylinder, "Segments", segments);
        }
        Dispatch.call(eCylinder, "Create");

    }

    public static class Builder {
        private boolean nestedReset = false;
        private String nestedMaterial;
        private String nestedName;
        private String nestedComponent;
        private SolidAxis nestedAxis;
        private double nestedXradius;
        private double nestedYradius;
        private double nestedZradius;
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

        public Builder xRadius(double xRadius) {
            this.nestedXradius = xRadius;
            return this;
        }

        public Builder yRadius(double yRadius) {
            this.nestedYradius = yRadius;
            return this;
        }

        public Builder zRadius(double zRadius) {
            this.nestedZradius = zRadius;
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

        public ECylinder build() {
            return new ECylinder(this);
        }
    }
}
