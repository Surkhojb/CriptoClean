package com.clean.juanjo.criptoclean.di.module;

import com.clean.juanjo.criptoclean.di.scope.PerActivity;
import com.clean.juanjo.criptoclean.ui.fragment.SettingsFragment;
import com.clean.juanjo.presentation.settingsfragment.SettingsFragmentContract;
import com.clean.juanjo.presentation.settingsfragment.SettingsFragmentPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by juanj on 16/01/2018.
 */

@Module
public class SettingsFragmentModule {
    SettingsFragment settingsFragment;

    public SettingsFragmentModule(SettingsFragment settingsFragment){
        this.settingsFragment = settingsFragment;
    }

    @PerActivity
    @Provides
    SettingsFragmentContract.Presenter providesPresenter(SettingsFragmentPresenter presenter){
        return presenter;
    }

    @PerActivity
    @Provides
    SettingsFragmentContract.View providesView(){
        return settingsFragment;
    }
}
