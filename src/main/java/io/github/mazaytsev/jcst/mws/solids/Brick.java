package io.github.mazaytsev.jcst.mws.solids;

import com.jacob.com.Dispatch;
import io.github.mazaytsev.jcst.ProjectInstance;
import io.github.mazaytsev.jcst.utils.Tuple;

public class Brick {
    private Boolean reset;
    private String material;
    private String name;
    private String component;
    private Tuple<Double, Double> xrange;
    private Tuple<Double, Double> yrange;
    private Tuple<Double, Double> zrange;
    private ProjectInstance projectInstance;

    private Brick(Builder build) {
        this.reset = build.nestedReset;
        this.material = build.nestedMaterial;
        this.name = build.nestedName;
        this.component = build.nestedComponent;
        this.xrange = build.nestedXrange;
        this.yrange = build.nestedYrange;
        this.zrange = build.nestedZrange;
        this.projectInstance = build.nestedProjectInstance;
        execute();
    }

    private void execute() {
        if (projectInstance == null) {
            return;
        }
        Dispatch brick = Dispatch.call(projectInstance.getDocument(), "Brick").toDispatch();
        if (reset) {
            Dispatch.call(brick, "Reset");
        }
        if (name != null) {
            Dispatch.call(brick, "Name", name);
        }
        if (component != null) {
            Dispatch.call(brick, "Component", component);
        }
        if (material != null) {
            Dispatch.call(brick, "Material", material);
        }
        if (xrange != null) {
            Dispatch.call(brick, "Xrange", xrange.getX(), xrange.getY());
        }
        if (yrange != null) {
            Dispatch.call(brick, "Yrange", yrange.getX(), yrange.getY());
        }
        if (zrange != null) {
            Dispatch.call(brick, "Zrange", zrange.getX(), zrange.getY());
        }
        Dispatch.call(brick, "Create");
    }

    public static class Builder {
        private boolean nestedReset = false;
        private String nestedMaterial;
        private String nestedName;
        private String nestedComponent;
        private Tuple<Double, Double> nestedXrange;
        private Tuple<Double, Double> nestedYrange;
        private Tuple<Double, Double> nestedZrange;
        private ProjectInstance nestedProjectInstance;

        public Builder(ProjectInstance projectInstance, String objectName) {
            this.nestedName = objectName;
            this.nestedProjectInstance = projectInstance;
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

        public Brick build() {
            return new Brick(this);
        }

    }

}
