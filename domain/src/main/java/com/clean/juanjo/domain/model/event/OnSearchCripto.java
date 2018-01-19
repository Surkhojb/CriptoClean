package com.clean.juanjo.domain.model.event;

/**
 * Created by juanj on 12/01/2018.
 */

public class OnSearchCripto {
    private String name;
    private String converted;

    public OnSearchCripto(String name, String converted) {
        this.name = name;
        this.converted = converted;
    }

    public String getName() {
        return name;
    }

    public String getConverted() {
        return converted;
    }
}
