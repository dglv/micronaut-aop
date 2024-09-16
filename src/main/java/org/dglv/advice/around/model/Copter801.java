package org.dglv.advice.around.model;

import io.micronaut.context.annotation.Parameter;
import io.micronaut.context.annotation.Prototype;

@Prototype
public class Copter801 extends UAVModel {
    public Copter801(@Parameter int serialNumber) {
        super("801", serialNumber);
    }
}
