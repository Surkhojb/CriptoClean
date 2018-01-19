package com.clean.juanjo.criptoclean.di.module;

import com.clean.juanjo.criptoclean.di.scope.PerActivity;
import com.clean.juanjo.criptoclean.ui.fragment.TopFragment;
import com.clean.juanjo.presentation.topfragment.TopFragmentContract;
import com.clean.juanjo.presentation.topfragment.TopFragmentPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by juanj on 12/01/2018.
 */

@Module
public class TopFragmentModule {

    TopFragment topFragment;

    public TopFragmentModule(TopFragment topFragment) {
        this.topFragment = topFragment;
    }

    @PerActivity
    @Provides
    TopFragmentContract.Presenter providesPresenter(TopFragmentPresenter presenter){
        return presenter;
    }

    @PerActivity
    @Provides
    TopFragmentContract.View providesView(){
        return topFragment;
    }
}
