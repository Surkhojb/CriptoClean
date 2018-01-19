package com.clean.juanjo.datasource.cloud;

import com.clean.juanjo.datasource.cloud.model.mapper.ApiCriptoTransformer;
import com.clean.juanjo.domain.model.CriptoModel;
import com.clean.juanjo.repository.datasource.cloud.ApiDatasource;

import java.util.List;

import javax.inject.Inject;

import dagger.Lazy;
import io.reactivex.Observable;

/**
 * Created by juanj on 11/01/2018.
 */

public class RestApiDatasource implements ApiDatasource {

    @Inject
    Lazy<ApiService> apiServiceLazy;
    @Inject
    ApiCriptoTransformer transformer;

    @Inject
    public RestApiDatasource(){}

    @Override
    public Observable<List<CriptoModel>> getCriptos(String num,String convert) {

        return apiServiceLazy.get().getListCriptos(num,convert).map(dtos -> transformer.transformCriptos(dtos));
    }

    @Override
    public Observable<List<CriptoModel>> getCriptoByName(String name,String convert) {
        return apiServiceLazy.get().getCriptoByName(name,convert).map(dtos -> transformer.transformCriptos(dtos));
    }
}
