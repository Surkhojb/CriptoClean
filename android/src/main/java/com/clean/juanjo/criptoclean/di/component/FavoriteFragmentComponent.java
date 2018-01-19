package com.clean.juanjo.criptoclean.di.component;

import com.clean.juanjo.criptoclean.di.module.FavoriteFragmentModule;
import com.clean.juanjo.criptoclean.di.scope.PerActivity;
import com.clean.juanjo.criptoclean.ui.fragment.FavoriteFragment;

import dagger.Component;

/**
 * Created by juanj on 18/01/2018.
 */

@PerActivity
@Component(dependencies = CriptoAppComponent.class,modules = FavoriteFragmentModule.class)
public interface FavoriteFragmentComponent {
    void inject(FavoriteFragment fragment);
}
