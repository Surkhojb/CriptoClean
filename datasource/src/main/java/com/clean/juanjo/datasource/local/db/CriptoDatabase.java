package com.clean.juanjo.datasource.local.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.clean.juanjo.datasource.local.db.favorite.FavoriteDao;
import com.clean.juanjo.datasource.local.db.favorite.model.FavoriteVo;
import com.clean.juanjo.datasource.local.db.top.CriptoDao;
import com.clean.juanjo.datasource.local.db.top.model.CriptoVo;

/**
 * Created by juanj on 15/01/2018.
 */

@Database(entities = {CriptoVo.class, FavoriteVo.class}, version = 1,exportSchema = false)
public abstract class CriptoDatabase extends RoomDatabase {
    public abstract CriptoDao criptoDao();
    public abstract FavoriteDao favoriteDao();
}
