package io.github.mazaytsev.jcst.mws;

import com.jacob.com.Dispatch;
import io.github.mazaytsev.jcst.ProjectInstance;
import io.github.mazaytsev.jcst.enums.FrequencyUnit;
import io.github.mazaytsev.jcst.enums.GeometryUnit;
import io.github.mazaytsev.jcst.enums.TemperatureUnit;
import io.github.mazaytsev.jcst.enums.TimeUnit;

public class Units {
    private FrequencyUnit frequencyUnit;
    private GeometryUnit geometryUnit;
    private TemperatureUnit temperatureUnit;
    private TimeUnit timeUnit;
    private ProjectInstance projectInstance;

    private Units(Builder builder){
        this.projectInstance =builder.projectInstance;
        this.frequencyUnit=builder.nestedFreqUnit;
        this.geometryUnit=builder.nestedGeomUnit;
        this.temperatureUnit=builder.nestedTempUnit;
        this.timeUnit=builder.nestedTimeUnit;
        execute();
    }

    public static class Builder{
        private FrequencyUnit nestedFreqUnit;
        private GeometryUnit nestedGeomUnit;
        private TemperatureUnit nestedTempUnit;
        private TimeUnit nestedTimeUnit;
        private ProjectInstance projectInstance;

        public Builder(ProjectInstance projectInstance){
            this.projectInstance = projectInstance;
        }

        public Builder freqUnit(FrequencyUnit nestedFreqUnit) {
            this.nestedFreqUnit = nestedFreqUnit;
            return this;
        }

        public Builder geomUnit(GeometryUnit nestedGeomUnit) {
            this.nestedGeomUnit = nestedGeomUnit;
            return this;
        }

        public Builder tempUnit(TemperatureUnit nestedTempUnit) {
            this.nestedTempUnit = nestedTempUnit;
            return this;
        }

        public Builder timeUnit(TimeUnit nestedTimeUnit) {
            this.nestedTimeUnit = nestedTimeUnit;
            return this;
        }

        public Units build(){
            return new Units(this);
        }
    }

    private void execute() {
        if (projectInstance ==null){
            return;
        }
        Dispatch units = Dispatch.call(projectInstance.getDocument(), "Units").toDispatch();
        if (frequencyUnit!=null){
            Dispatch.call(units,"Frequency", frequencyUnit.getFrequencyUnit());
        }
        if (frequencyUnit!=null){
            Dispatch.call(units,"Geometry", geometryUnit.getGeomteryUnit());
        }
        if (temperatureUnit!=null){
            Dispatch.call(units,"TemperatureUnit", temperatureUnit.getTemperatureUnit());
        }
        if (timeUnit!=null){
            Dispatch.call(units,"Time", timeUnit.getTimeUnit());
        }
    }

    public String getGeometryUnit(){
       Dispatch units = Dispatch.call(projectInstance.getDocument(),"Units").toDispatch();
       return Dispatch.call(units, "GetGeometryUnit").getString();
    }

    public double getGeometryUnitToSI(){
        Dispatch units = Dispatch.call(projectInstance.getDocument(),"Units").toDispatch();
        return Dispatch.call(units, "GetGeometryUnitToSI").getDouble();
    }

    public double getGeometrySIToUnit(){
        Dispatch units = Dispatch.call(projectInstance.getDocument(),"Units").toDispatch();
        return Dispatch.call(units, "GetGeometrySIToUnit").getDouble();
    }

    public String getTimeUnit(){
        Dispatch units = Dispatch.call(projectInstance.getDocument(),"Units").toDispatch();
        return Dispatch.call(units, "GetTimeUnit").getString();
    }

    public double getTimeUnitToSI(){
        Dispatch units = Dispatch.call(projectInstance.getDocument(),"Units").toDispatch();
        return Dispatch.call(units, "GetTimeUnitToSI").getDouble();
    }

    public double getTimeSIToUnit(){
        Dispatch units = Dispatch.call(projectInstance.getDocument(),"Units").toDispatch();
        return Dispatch.call(units, "GetTimeSIToUnit").getDouble();
    }

    public String getFrequencyUnit(){
        Dispatch units = Dispatch.call(projectInstance.getDocument(),"Units").toDispatch();
        return Dispatch.call(units, "GetFrequencyUnit").getString();
    }

    public double getFrequencyUnitToSI(){
        Dispatch units = Dispatch.call(projectInstance.getDocument(),"Units").toDispatch();
        return Dispatch.call(units, "GetFrequencyUnitToSI").getDouble();
    }

    public double getFrequencySIToUnit(){
        Dispatch units = Dispatch.call(projectInstance.getDocument(),"Units").toDispatch();
        return Dispatch.call(units, "GetFrequencySIToUnit").getDouble();
    }


}
