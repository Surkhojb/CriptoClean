package com.clean.juanjo.domain.model;

/**
 * Created by juanj on 16/01/2018.
 */

public class CriptoSettingsModel {
    String currency;
    String numOfItems;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getNumOfItems() {
        return numOfItems;
    }

    public void setNumOfItems(String numOfItems) {
        this.numOfItems = numOfItems;
    }
}
