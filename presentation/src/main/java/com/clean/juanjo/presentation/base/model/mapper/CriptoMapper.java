package com.clean.juanjo.presentation.base.model.mapper;

import com.clean.juanjo.presentation.base.Mapper;
import com.clean.juanjo.presentation.base.model.Cripto;
import com.clean.juanjo.domain.model.CriptoModel;

import javax.inject.Inject;


/**
 * Created by juanj on 15/01/2018.
 */

public class CriptoMapper implements Mapper<Cripto,CriptoModel> {

    @Inject
    CriptoMapper(){

    }

    @Override
    public Cripto map(CriptoModel model) {
        Cripto cripto = new Cripto();

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

    @Override
    public CriptoModel inverseMap(Cripto cripto) {
        CriptoModel model = new CriptoModel();
        model.setId(cripto.getId());
        model.setName(cripto.getName());
        model.setRank(cripto.getRank());
        model.setSymbol(cripto.getSymbol());
        model.setPriceBtc(cripto.getPriceBtc());
        model.setPriceUsd(cripto.getPriceUsd());
        model.setPriceEur(cripto.getPriceEur());
        model.setPercentChange1h(cripto.getPercentChange1h());
        model.setPercentChange24h(cripto.getPercentChange24h());
        model.setPercentChange7d(cripto.getPercentChange7d());
        model.setLastUpdated(cripto.getLastUpdated());

        return model;
    }
}
