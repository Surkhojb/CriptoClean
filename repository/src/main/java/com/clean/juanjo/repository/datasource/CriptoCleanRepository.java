package com.clean.juanjo.repository.datasource;

import com.clean.juanjo.domain.model.CriptoModel;
import com.clean.juanjo.domain.repository.CriptoRepository;
import com.clean.juanjo.repository.datasource.cloud.ApiDatasource;
import com.clean.juanjo.repository.datasource.local.ILocalDataSource;
import com.clean.juanjo.repository.datasource.local.ISettingsPreferences;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.functions.Action;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by juanj on 11/01/2018.
 */

public class CriptoCleanRepository implements CriptoRepository {

    @Inject
    ApiDatasource apiDatasource;
    @Inject
    ILocalDataSource localDataSource;
    @Inject
    ISettingsPreferences preferencesManager;

    Observable<List<CriptoModel>> dbResults;
    Observable<List<CriptoModel>> apiResults;

    @Inject
    CriptoCleanRepository(){}

    @Override
    public Observable<List<CriptoModel>> getCriptos() {
        dbResults = localDataSource.getCriptos();

        apiResults = apiDatasource.getCriptos(
                preferencesManager.getDefaultNumOfItem(),preferencesManager.getDefaultCurrency())
                .doOnNext(criptoModels -> localDataSource.saveCriptos(criptoModels));

        return Observable.concat(dbResults,apiResults);

    }

    @Override
    public Observable<List<CriptoModel>> getCriptoByName(String name) {
        return apiDatasource.getCriptoByName(name,preferencesManager.getDefaultCurrency());
    }

    @Override
    public boolean saveCriptoAppSettings(String numOfItems){
        return  preferencesManager.insertDefaultNumOfItems(numOfItems) ? true :false;

    }

    @Override
    public boolean addToFavorites(CriptoModel model) {
        localDataSource.addToFavorites(model).subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io()).subscribe(() -> {});

        return true;
    }

    @Override
    public Observable<List<CriptoModel>> getFavorites() {
        return localDataSource.getFavorites();
    }
}
