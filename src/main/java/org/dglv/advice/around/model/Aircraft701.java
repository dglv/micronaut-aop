package org.dglv.advice.around.model;

import io.micronaut.context.annotation.Parameter;
import io.micronaut.context.annotation.Prototype;

@Prototype
public class Aircraft701 extends UAVModel {

    public Aircraft701(@Parameter int serialNumber) {
        super("701", serialNumber);
    }
}
