package com.clean.juanjo.domain.repository;

import com.clean.juanjo.domain.model.CriptoModel;

import java.util.List;

import io.reactivex.Observable;


/**
 * Created by juanj on 11/01/2018.
 */

public interface CriptoRepository {

    Observable<List<CriptoModel>> getCriptos();

    Observable<List<CriptoModel>> getCriptoByName(String name);

    boolean addToFavorites(CriptoModel model);

    Observable<List<CriptoModel>> getFavorites();

    boolean saveCriptoAppSettings(String numOfItems);
}
