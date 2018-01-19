package com.clean.juanjo.criptoclean.di.component;

import com.clean.juanjo.criptoclean.CriptoApp;
import com.clean.juanjo.criptoclean.di.scope.PerActivity;
import com.clean.juanjo.criptoclean.ui.activity.MainActivity;

import dagger.Component;

/**
 * Created by juanj on 12/01/2018.
 */
@PerActivity @Component(dependencies = CriptoAppComponent.class)
public interface MainActivityComponent {
    void inject(MainActivity activity);
}
