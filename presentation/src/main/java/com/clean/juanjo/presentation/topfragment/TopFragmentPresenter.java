package com.clean.juanjo.presentation.topfragment;

import com.clean.juanjo.domain.interactor.AddToFavoritesUseCase;
import com.clean.juanjo.domain.interactor.DefaultObserver;
import com.clean.juanjo.domain.interactor.GetCriptoByNameUseCase;
import com.clean.juanjo.domain.interactor.GetTopUseCase;
import com.clean.juanjo.domain.model.CriptoModel;
import com.clean.juanjo.presentation.base.model.Cripto;
import com.clean.juanjo.presentation.base.model.mapper.CriptoTransformer;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by juanj on 11/01/2018.
 */

public class TopFragmentPresenter implements TopFragmentContract.Presenter {

    @Inject
    TopFragmentContract.View view;
    @Inject
    CriptoTransformer mapper;
    @Inject
    GetTopUseCase getTop;
    @Inject
    GetCriptoByNameUseCase getCripto;
    @Inject
    AddToFavoritesUseCase addToFavorite;

    @Inject
    public  TopFragmentPresenter(){}

    @Override
    public void loadCriptos() {
        view.showLoading(true);
        getTop.execute(new GetTopObserver(),GetTopUseCase.Params.create());

    }

    @Override
    public void loadCriptosByName(String name) {
        view.showLoading(true);
        getCripto.execute(new GetTopObserver(),GetCriptoByNameUseCase.Params.create(name));

    }

    @Override
    public void addToFavorites(Cripto cripto) {
        System.out.println("FAV Item presenter: "+cripto.getId());
        addToFavorite.execute(new AddFavoriteObserver(),AddToFavoritesUseCase.Params.create(mapper.transformToModel(cripto)));
    }

    final class GetTopObserver extends DefaultObserver<List<CriptoModel>>{

        @Override
        public void onNext(List<CriptoModel> criptoModels) {
            view.showListOfCriptos(mapper.transformCriptos(criptoModels));
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

    final class AddFavoriteObserver extends DefaultObserver<Boolean>{

        @Override
        public void onNext(Boolean aBoolean) {
            if(aBoolean)
                view.showMessage("Cripto added to Favorite");
            else
                view.showError("Error adding to favorites.");
        }

        @Override
        public void onComplete() {
            super.onComplete();
        }

        @Override
        public void onError(Throwable exception) {
            view.showError(exception.getLocalizedMessage());
        }
    }

}
