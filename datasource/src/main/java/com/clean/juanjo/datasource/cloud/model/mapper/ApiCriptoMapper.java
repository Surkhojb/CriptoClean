package com.clean.juanjo.datasource.cloud.model.mapper;

import com.clean.juanjo.datasource.base.Mapper;
import com.clean.juanjo.datasource.cloud.model.CriptoDto;
import com.clean.juanjo.domain.model.CriptoModel;

import javax.inject.Inject;


/**
 * Created by juanj on 11/01/2018.
 */

public class ApiCriptoMapper implements Mapper<CriptoDto,CriptoModel> {

    @Inject
    public ApiCriptoMapper(){}

    @Override
    public CriptoDto map(CriptoModel model) {
        return null;
    }

    @Override
    public CriptoModel inverseMap(CriptoDto dto) {
        CriptoModel cripto = new CriptoModel();
        cripto.setId(dto.getId());
        cripto.setName(dto.getName());
        cripto.setRank(dto.getRank());
        cripto.setSymbol(dto.getSymbol());
        cripto.setPriceBtc(parseToDouble(dto.getPriceBtc()));
        cripto.setPriceUsd(parseToDouble(dto.getPriceUsd()));
        cripto.setPriceEur(parseToDouble(dto.getPriceEur()));
        cripto.setPercentChange1h(parseToDouble(dto.getPercentChange1h()));
        cripto.setPercentChange24h(parseToDouble(dto.getPercentChange24h()));
        cripto.setPercentChange7d(parseToDouble(dto.getPercentChange7d()));
        cripto.setLastUpdated(dto.getLastUpdated());

        return cripto;
    }

    double parseToDouble(String value){
        double price = 0;
        try{
            price = Double.parseDouble(value);
        }catch (NumberFormatException ex){
            price = 0;
        }

        return price;
    }
}
