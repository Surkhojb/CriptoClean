package com.clean.juanjo.criptoclean.di.component;

import com.clean.juanjo.criptoclean.di.module.SettingsFragmentModule;
import com.clean.juanjo.criptoclean.di.scope.PerActivity;
import com.clean.juanjo.criptoclean.ui.fragment.SettingsFragment;


import dagger.Component;

/**
 * Created by juanj on 16/01/2018.
 */

@PerActivity
@Component(dependencies = CriptoAppComponent.class,modules = {SettingsFragmentModule.class})
public interface SettingsFragComponent {
    void inject(SettingsFragment fragment);
}
