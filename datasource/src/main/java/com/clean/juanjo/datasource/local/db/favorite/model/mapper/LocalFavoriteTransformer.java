package com.clean.juanjo.datasource.local.db.favorite.model.mapper;

import com.clean.juanjo.datasource.local.db.favorite.FavoriteDao;
import com.clean.juanjo.datasource.local.db.favorite.model.FavoriteVo;
import com.clean.juanjo.domain.model.CriptoModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by juanj on 19/01/2018.
 */

public class LocalFavoriteTransformer {

    @Inject
    LocalFavoriteMapper mapper;

    @Inject
    public LocalFavoriteTransformer(){}

    public List<CriptoModel> transformToModel(List<FavoriteVo> vos){
        List<CriptoModel> criptos = new ArrayList<>();
        for(FavoriteVo vo : vos)
            criptos.add(mapper.map(vo));

        return criptos;
    }

    public List<FavoriteVo> transformToVo(List<CriptoModel> models){
        List<FavoriteVo> criptos = new ArrayList<>();
        for(CriptoModel model : models)
            criptos.add(mapper.inverseMap(model));

        return criptos;
    }

    public FavoriteVo mapToFavoriteVo(CriptoModel model){
        return mapper.inverseMap(model);
    }
}
