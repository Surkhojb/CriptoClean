package com.clean.juanjo.criptoclean;

import android.app.Application;


import com.clean.juanjo.criptoclean.di.component.CriptoAppComponent;
import com.clean.juanjo.criptoclean.di.component.DaggerCriptoAppComponent;
import com.clean.juanjo.criptoclean.di.module.CriptoAppModule;
import com.clean.juanjo.criptoclean.di.module.DataSourceModule;

/**
 * Created by juanj on 11/01/2018.
 */

public class CriptoApp extends Application {
    private CriptoAppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        injectDependencies();
    }

    void  injectDependencies(){
        appComponent = DaggerCriptoAppComponent.builder()
                .criptoAppModule(new CriptoAppModule(this))
                .dataSourceModule(new DataSourceModule(this))
                .build();

        appComponent.inject(this);
    }

    public CriptoAppComponent getAppComponent(){
        return appComponent;
    }
}
