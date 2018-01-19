package com.clean.juanjo.repository.datasource.local;

/**
 * Created by juanj on 16/01/2018.
 */

public interface ISettingsPreferences {
    boolean insertDefaultCurrency(String currency);
    String getDefaultCurrency();
    boolean insertDefaultNumOfItems(String num);
    String getDefaultNumOfItem();
}
