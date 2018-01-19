package com.clean.juanjo.datasource.local.db.top.model.mapper;


import com.clean.juanjo.datasource.base.Mapper;
import com.clean.juanjo.datasource.local.db.top.model.CriptoVo;
import com.clean.juanjo.domain.model.CriptoModel;

import javax.inject.Inject;

/**
 * Created by juanj on 15/01/2018.
 */

public class LocalCriptoMapper implements Mapper<CriptoModel,CriptoVo> {

    @Inject
    public LocalCriptoMapper(){

    }

    @Override
    public CriptoModel map(CriptoVo vo) {
        CriptoModel cripto = new CriptoModel();
        cripto.setId(vo.getId());
        cripto.setName(vo.getName());
        cripto.setRank(vo.getRank());
        cripto.setSymbol(vo.getSymbol());
        cripto.setPriceBtc(vo.getPriceBtc());
        cripto.setPriceUsd(vo.getPriceUsd());
        cripto.setPriceEur(vo.getPriceEur());
        cripto.setPercentChange1h(vo.getPercentChange1h());
        cripto.setPercentChange24h(vo.getPercentChange24h());
        cripto.setPercentChange7d(vo.getPercentChange7d());
        cripto.setLastUpdated(vo.getLastUpdated());
        
        return cripto;
    }

    @Override
    public CriptoVo inverseMap(CriptoModel model) {
        CriptoVo cripto = new CriptoVo();
        cripto.setId(model.getId());
        cripto.setName(model.getName());
        cripto.setRank(model.getRank());
        cripto.setSymbol(model.getSymbol());
        cripto.setPriceBtc(model.getPriceBtc());
        cripto.setPriceUsd(model.getPriceUsd());
        cripto.setPriceEur(model.getPriceEur());
        cripto.setPercentChange1h(model.getPercentChange1h());
        cripto.setPercentChange24h(model.getPercentChange24h());
        cripto.setPercentChange7d(model.getPercentChange7d());
        cripto.setLastUpdated(model.getLastUpdated());

        return cripto;
    }
}
