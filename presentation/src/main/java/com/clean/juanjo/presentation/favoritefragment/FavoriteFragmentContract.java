package com.clean.juanjo.presentation.favoritefragment;

import com.clean.juanjo.presentation.topfragment.model.Cripto;

import java.util.List;

/**
 * Created by juanj on 18/01/2018.
 */

public interface FavoriteFragmentContract {
    interface View {
        void showListOfFavorites(List<Cripto> criptos);
        void showMessage(String message);
        void showError(String errorMessage);
        void showLoading(boolean status);
    }

    interface Presenter{
        void loadFavorites();
        void removeFavorite(Cripto cripto);
    }

}
