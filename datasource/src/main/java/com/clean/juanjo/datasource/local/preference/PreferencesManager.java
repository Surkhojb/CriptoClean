package com.clean.juanjo.datasource.local.preference;

import android.content.SharedPreferences;
import com.clean.juanjo.repository.datasource.local.ISettingsPreferences;

import javax.inject.Inject;

/**
 * Created by juanj on 16/01/2018.
 */

public class PreferencesManager implements ISettingsPreferences {

    private static final String PREF_CURRENCY = "pref_currency";
    private static final String PREF_DEFAULT_CURRENCY = "EUR";
    private static final String PREF_ITEMS = "pref_items";
    private static final String PREF_ITEMS_DEFAULT = "10";

    SharedPreferences preferences;

    @Inject
    public PreferencesManager(SharedPreferences pref){
        this.preferences = pref;
    }

    @Override
    public boolean insertDefaultCurrency(String currency){
        preferences.edit().putString(PREF_CURRENCY,currency).apply();
        return true;
    }

    @Override
    public String getDefaultCurrency(){
        if(preferences.getString(PREF_CURRENCY,PREF_DEFAULT_CURRENCY) == null)
            insertDefaultCurrency(PREF_DEFAULT_CURRENCY);
        return preferences.getString(PREF_CURRENCY,PREF_DEFAULT_CURRENCY);
    }

    @Override
    public boolean insertDefaultNumOfItems(String num){
        if(num.isEmpty() || num.toString().equals("0")) {
            preferences.edit().putString(PREF_ITEMS, PREF_ITEMS_DEFAULT).apply();
            return true;
        }
        else {
            preferences.edit().putString(PREF_ITEMS, num).apply();
            return true;
        }
    }
    @Override
    public String getDefaultNumOfItem(){
        if( preferences.getString(PREF_ITEMS,PREF_ITEMS_DEFAULT) == null)
            insertDefaultNumOfItems(PREF_ITEMS_DEFAULT);
        return preferences.getString(PREF_ITEMS,PREF_ITEMS_DEFAULT);
    }


}
