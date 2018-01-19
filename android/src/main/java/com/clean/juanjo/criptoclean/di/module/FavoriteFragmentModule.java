package com.clean.juanjo.criptoclean.di.module;

import android.app.FragmentContainer;

import com.clean.juanjo.criptoclean.di.scope.PerActivity;
import com.clean.juanjo.criptoclean.ui.fragment.FavoriteFragment;
import com.clean.juanjo.presentation.favoritefragment.FavoriteFragmentContract;
import com.clean.juanjo.presentation.favoritefragment.FavoriteFragmentPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by juanj on 18/01/2018.
 */

@Module
public class FavoriteFragmentModule {

    FavoriteFragment fragment;

    public FavoriteFragmentModule(FavoriteFragment favoriteFragment){
        this.fragment = favoriteFragment;
    }

    @PerActivity
    @Provides
    FavoriteFragmentContract.View provideView(){
        return this.fragment;
    }

    @PerActivity
    @Provides
    FavoriteFragmentContract.Presenter providePresenter(FavoriteFragmentPresenter presenter){
        return presenter;
    }
}
