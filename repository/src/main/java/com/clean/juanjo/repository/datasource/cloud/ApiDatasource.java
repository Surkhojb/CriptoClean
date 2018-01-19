package com.clean.juanjo.repository.datasource.cloud;

import com.clean.juanjo.domain.model.CriptoModel;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by juanj on 11/01/2018.
 */

public interface ApiDatasource {
    Observable<List<CriptoModel>> getCriptos(String num,String convert);
    Observable<List<CriptoModel>> getCriptoByName(String name,String convert);
}

