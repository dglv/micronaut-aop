package org.dglv.model;

import io.micronaut.context.annotation.Parameter;
import io.micronaut.context.annotation.Prototype;

@Prototype
public class Geoscan801 extends UAVModel {
    public Geoscan801(@Parameter int serialNumber) {
        super("801", serialNumber);
    }
}
