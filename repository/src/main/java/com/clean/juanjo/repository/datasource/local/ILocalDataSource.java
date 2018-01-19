package com.clean.juanjo.repository.datasource.local;

import com.clean.juanjo.domain.model.CriptoModel;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;

/**
 * Created by juanj on 15/01/2018.
 */

public interface ILocalDataSource {
    Observable<List<CriptoModel>> getCriptos();
    Observable<List<CriptoModel>> getCriptoById(String id);
    void saveCriptos(List<CriptoModel> criptoModels);
    Completable addToFavorites(CriptoModel model);
    Observable<List<CriptoModel>> getFavorites();
}
