package com.clean.juanjo.presentation.topfragment;

import com.clean.juanjo.domain.model.CriptoModel;
import com.clean.juanjo.presentation.topfragment.model.Cripto;

import java.util.List;

/**
 * Created by juanj on 11/01/2018.
 */

public interface TopFragmentContract {

    interface View{
        void showLoading(boolean status);
        void showMessage(String message);
        void showError(String errorMessage);
        void showListOfCriptos(List<Cripto> criptos);
    }

    interface Presenter{
        void loadCriptos();
        void loadCriptosByName(String name);
        void addToFavorites(Cripto cripto);
    }
}
