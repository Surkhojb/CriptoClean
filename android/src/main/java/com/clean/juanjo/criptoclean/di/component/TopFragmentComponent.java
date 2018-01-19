package com.clean.juanjo.criptoclean.di.component;

import com.clean.juanjo.criptoclean.di.module.TopFragmentModule;
import com.clean.juanjo.criptoclean.di.scope.PerActivity;
import com.clean.juanjo.criptoclean.ui.fragment.TopFragment;


import dagger.Component;

/**
 * Created by juanj on 12/01/2018.
 */

@PerActivity
@Component(dependencies = CriptoAppComponent.class,modules = {TopFragmentModule.class})
public interface TopFragmentComponent {
    void inject(TopFragment fragment);
}
