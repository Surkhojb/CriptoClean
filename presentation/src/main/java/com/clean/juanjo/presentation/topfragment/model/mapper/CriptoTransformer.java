package com.clean.juanjo.presentation.topfragment.model.mapper;

import com.clean.juanjo.domain.model.CriptoModel;
import com.clean.juanjo.presentation.topfragment.model.Cripto;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by juanj on 11/01/2018.
 */

public class CriptoTransformer {

    @Inject CriptoMapper  criptoMapper;

    @Inject public CriptoTransformer(){}

    public List<Cripto> transformCriptos(List<CriptoModel> models){
        List<Cripto> criptos = new ArrayList<>();
        for(CriptoModel model : models)
            criptos.add(criptoMapper.map(model));

        return criptos;
    }

    public Cripto transformCripto(CriptoModel model){
        return criptoMapper.map(model);
    }

    public CriptoModel transformToModel(Cripto cripto){
        System.out.println("FAV mapper: "+cripto.getId());
        return criptoMapper.inverseMap(cripto);
    }

}
