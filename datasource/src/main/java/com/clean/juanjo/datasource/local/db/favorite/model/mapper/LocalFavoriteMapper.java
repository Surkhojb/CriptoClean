package com.clean.juanjo.datasource.local.db.favorite.model.mapper;

import com.clean.juanjo.datasource.base.Mapper;
import com.clean.juanjo.datasource.local.db.favorite.model.FavoriteVo;
import com.clean.juanjo.domain.model.CriptoModel;

import javax.inject.Inject;

/**
 * Created by juanj on 19/01/2018.
 */

public class LocalFavoriteMapper implements Mapper<CriptoModel,FavoriteVo> {

    @Inject
    public LocalFavoriteMapper(){}

    @Override
    public CriptoModel map(FavoriteVo vo) {
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
    public FavoriteVo inverseMap(CriptoModel model) {
        FavoriteVo cripto = new FavoriteVo();
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
