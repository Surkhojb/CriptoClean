package com.clean.juanjo.datasource.local.db.top.model.mapper;


import com.clean.juanjo.datasource.local.db.top.model.CriptoVo;
import com.clean.juanjo.domain.model.CriptoModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by juanj on 15/01/2018.
 */

public class LocalCriptoTransformer {

    @Inject
    LocalCriptoMapper localCriptoMapper;

    @Inject
    public LocalCriptoTransformer(){}

    public List<CriptoModel> transformToModel(List<CriptoVo> vos){
        List<CriptoModel> criptos = new ArrayList<>();
        for(CriptoVo vo : vos)
            criptos.add(localCriptoMapper.map(vo));

        return criptos;
    }

    public List<CriptoVo> transformToVo(List<CriptoModel> models){
        List<CriptoVo> criptos = new ArrayList<>();
        for(CriptoModel model : models)
            criptos.add(localCriptoMapper.inverseMap(model));

        return criptos;
    }


}
