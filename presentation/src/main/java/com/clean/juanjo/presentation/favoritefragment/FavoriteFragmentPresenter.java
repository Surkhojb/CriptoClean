package com.clean.juanjo.presentation.favoritefragment;

import com.clean.juanjo.domain.interactor.DefaultObserver;
import com.clean.juanjo.domain.interactor.GetFavoritesUseCase;
import com.clean.juanjo.domain.model.CriptoModel;
import com.clean.juanjo.presentation.base.model.Cripto;
import com.clean.juanjo.presentation.base.model.mapper.CriptoTransformer;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by juanj on 18/01/2018.
 */

public class FavoriteFragmentPresenter implements FavoriteFragmentContract.Presenter{

    @Inject
    FavoriteFragmentContract.View view;

    @Inject
    GetFavoritesUseCase getFavorites;

    @Inject
    CriptoTransformer transformer;

    @Inject
    public FavoriteFragmentPresenter(){

    }


    @Override
    public void loadFavorites() {
        view.showLoading(true);
        System.out.println("FAV Get favorites");
        getFavorites.execute(new FavoriteFragmentPresenter.GetFavoriteObserver(),GetFavoritesUseCase.Params.create());
    }

    @Override
    public void removeFavorite(Cripto cripto) {

    }

    final class GetFavoriteObserver extends DefaultObserver<List<CriptoModel>> {

        @Override
        public void onNext(List<CriptoModel> criptoModels) {
            System.out.println("FAV Get favorites: "+criptoModels.size());
            view.showListOfFavorites(transformer.transformCriptos(criptoModels));
        }

        @Override
        public void onComplete() {
            view.showLoading(false);
        }

        @Override
        public void onError(Throwable exception) {
            view.showLoading(false);
            view.showError(exception.getLocalizedMessage());
        }
    }
}
