package com.clean.juanjo.datasource.local.db.top;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.clean.juanjo.datasource.local.db.top.model.CriptoVo;

import java.util.List;

import io.reactivex.Single;

/**
 * Created by juanj on 15/01/2018.
 */

@Dao
public interface CriptoDao {

    @Query("SELECT * FROM criptos")
    Single<List<CriptoVo>> getCriptos();

    @Query("SELECT * FROM criptos WHERE id=:id")
    CriptoVo getCryptoById(String id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<CriptoVo> criptos);
}
