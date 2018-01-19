package com.clean.juanjo.datasource.local.db.top.model;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Created by juanj on 15/01/2018.
 */

@Entity(tableName = "criptos")
public class CriptoVo{

    @NonNull
    @PrimaryKey(autoGenerate = false)
    private String id;
    @ColumnInfo(name = "name")
    private String name;
    @ColumnInfo(name = "symbol")
    private String symbol;
    @ColumnInfo(name = "rank")
    private String rank;
    @ColumnInfo(name = "usd")
    private double priceUsd;
    @ColumnInfo(name = "eur")
    private double priceEur;
    @ColumnInfo(name = "btc")
    private double priceBtc;
    @ColumnInfo(name = "change_1h")
    private double percentChange1h;
    @ColumnInfo(name = "change_24h")
    private double percentChange24h;
    @ColumnInfo(name = "change_7d")
    private double percentChange7d;
    @ColumnInfo(name = "updated")
    private String lastUpdated;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public double getPriceUsd() {
        return priceUsd;
    }

    public void setPriceUsd(double priceUsd) {
        this.priceUsd = priceUsd;
    }

    public double getPriceEur() {
        return priceEur;
    }

    public void setPriceEur(double priceEur) {
        this.priceEur = priceEur;
    }

    public double getPriceBtc() {
        return priceBtc;
    }

    public void setPriceBtc(double priceBtc) {
        this.priceBtc = priceBtc;
    }

    public double getPercentChange1h() {
        return percentChange1h;
    }

    public void setPercentChange1h(double percentChange1h) {
        this.percentChange1h = percentChange1h;
    }

    public double getPercentChange24h() {
        return percentChange24h;
    }

    public void setPercentChange24h(double percentChange24h) {
        this.percentChange24h = percentChange24h;
    }

    public double getPercentChange7d() {
        return percentChange7d;
    }

    public void setPercentChange7d(double percentChange7d) {
        this.percentChange7d = percentChange7d;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

}
