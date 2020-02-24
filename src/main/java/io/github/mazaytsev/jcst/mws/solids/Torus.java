package io.github.mazaytsev.jcst.mws.solids;

import com.jacob.com.Dispatch;
import io.github.mazaytsev.jcst.ProjectInstance;
import io.github.mazaytsev.jcst.enums.SolidAxis;

public class Torus {
    private boolean reset;
    private String material;
    private String name;
    private String component;
    private SolidAxis axis;
    private double outerRadius;
    private double innerRadius;
    private double xcenter;
    private double ycenter;
    private double zcenter;
    private int segments;
    private ProjectInstance projectInstance;

    private Torus(Builder build) {
        this.reset = build.nestedReset;
        this.material = build.nestedMaterial;
        this.name = build.nestedName;
        this.component = build.nestedComponent;
        this.axis = build.nestedAxis;
        this.outerRadius = build.nestedOuterRadius;
        this.innerRadius = build.nestedInnerRadius;
        this.xcenter = build.nestedXcenter;
        this.ycenter = build.nestedYcenter;
        this.zcenter = build.nestedZcenter;
        this.segments = build.nestedSegments;
        this.projectInstance = build.nestedProjectInstance;
        execute();
    }

    private void execute() {
        if (projectInstance == null) {
            return;
        }
        Dispatch torus = Dispatch.call(projectInstance.getDocument(), "Torus").toDispatch();
        if (reset) {
            Dispatch.call(torus, "Reset");
        }
        if (name != null) {
            Dispatch.call(torus, "Name", name);
        }
        if (component != null) {
            Dispatch.call(torus, "Component", component);
        }
        if (material != null) {
            Dispatch.call(torus, "Material", material);
        }
        if (axis != null) {
            Dispatch.call(torus, "Axis", axis.getAxis());
        }
        if (outerRadius != 0) {
            Dispatch.call(torus, "Outerradius", outerRadius);
        }
        if (innerRadius != 0) {
            Dispatch.call(torus, "Innerradius", innerRadius);
        }
        if (xcenter != 0) {
            Dispatch.call(torus, "Xcenter", xcenter);
        }
        if (ycenter != 0) {
            Dispatch.call(torus, "Ycenter", ycenter);
        }
        if (zcenter != 0) {
            Dispatch.call(torus, "Zcenter", zcenter);
        }
        if (segments != 0) {
            Dispatch.call(torus, "Segments", segments);
        }
        Dispatch.call(torus, "Create");

    }

    public static class Builder {
        private boolean nestedReset = false;
        private String nestedMaterial;
        private String nestedName;
        private String nestedComponent;
        private SolidAxis nestedAxis;
        private double nestedOuterRadius;
        private double nestedInnerRadius;
        private double nestedXcenter;
        private double nestedYcenter;
        private double nestedZcenter;
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

        public Builder outerRadius(double outerRadius) {
            this.nestedOuterRadius = outerRadius;
            return this;
        }

        public Builder innerRadius(double innerRadius) {
            this.nestedInnerRadius = innerRadius;
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

        public Builder segments(int segments) {
            this.nestedSegments = segments;
            return this;
        }

        public Torus build() {
            return new Torus(this);
        }
    }
}
