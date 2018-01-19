package com.clean.juanjo.datasource.local.db;

import com.clean.juanjo.datasource.local.db.favorite.FavoriteDao;
import com.clean.juanjo.datasource.local.db.favorite.model.mapper.LocalFavoriteTransformer;
import com.clean.juanjo.datasource.local.db.top.CriptoDao;
import com.clean.juanjo.datasource.local.db.top.model.mapper.LocalCriptoTransformer;
import com.clean.juanjo.domain.model.CriptoModel;
import com.clean.juanjo.repository.datasource.local.ILocalDataSource;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by juanj on 15/01/2018.
 */

public class LocalDatasource implements ILocalDataSource {

    @Inject
    CriptoDao criptoDao;
    @Inject
    FavoriteDao favoriteDao;

    @Inject
    LocalCriptoTransformer criptoTransformer;
    @Inject
    LocalFavoriteTransformer favoriteTransformer;

    @Inject
    public LocalDatasource(){}

    @Override
    public Observable<List<CriptoModel>> getCriptos() {
        return criptoDao.getCriptos().map(criptoVos -> criptoTransformer.transformToModel(criptoVos)).toObservable();
    }

    @Override
    public Observable<List<CriptoModel>> getCriptoById(String id) {
        return null;
    }

    @Override
    public void saveCriptos(List<CriptoModel> criptoModels) {
        criptoDao.insertAll(criptoTransformer.transformToVo(criptoModels));
    }

    @Override
    public Completable addToFavorites(CriptoModel model) {
        System.out.println("FAV Model to insert: "+model.getId());
        return Completable.fromCallable(() -> favoriteDao.insert(favoriteTransformer.mapToFavoriteVo(model)));
    }

    @Override
    public Observable<List<CriptoModel>> getFavorites() {
        System.out.println("FAV Get favorites");
        return Observable.fromCallable(() -> favoriteTransformer.transformToModel(favoriteDao.getCriptos()));
    }
}
