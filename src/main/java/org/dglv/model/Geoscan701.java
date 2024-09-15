package org.dglv.model;

import io.micronaut.context.annotation.Parameter;
import io.micronaut.context.annotation.Prototype;

@Prototype
public class Geoscan701 extends UAVModel {

    public Geoscan701(@Parameter int serialNumber) {
        super("701", serialNumber);
    }
}
