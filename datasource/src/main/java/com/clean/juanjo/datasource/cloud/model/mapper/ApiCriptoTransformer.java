package com.clean.juanjo.datasource.cloud.model.mapper;

import com.clean.juanjo.datasource.cloud.model.CriptoDto;
import com.clean.juanjo.domain.model.CriptoModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by juanj on 11/01/2018.
 */

public class ApiCriptoTransformer {

    @Inject ApiCriptoMapper  apiCriptoMapper;

    @Inject public ApiCriptoTransformer(){}

    public List<CriptoModel> transformCriptos(List<CriptoDto> dtos){
        List<CriptoModel> criptos = new ArrayList<>();
        for(CriptoDto dto : dtos)
            criptos.add(apiCriptoMapper.inverseMap(dto));

        return criptos;
    }

}
