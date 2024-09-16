package org.dglv.advice.around.model;


import lombok.AllArgsConstructor;
import org.dglv.advice.around.TimeMeasured;

@AllArgsConstructor
public abstract class UAVModel {
    private final String model;
    private final int serialNumber;

    @TimeMeasured
    @Override
    public String toString() {
        return "UAVModel{" +
                "model='" + model + '\'' +
                ", serialNumber=" + serialNumber +
                '}';
    }
}
