package com.clean.juanjo.datasource.local.db.favorite;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.clean.juanjo.datasource.local.db.favorite.model.FavoriteVo;
import java.util.List;

import io.reactivex.Single;

/**
 * Created by juanj on 19/01/2018.
 */

@Dao
public interface FavoriteDao {

    @Query("SELECT * FROM favorites")
    List<FavoriteVo> getCriptos();

    @Query("SELECT * FROM favorites WHERE id=:id")
    FavoriteVo getFavoriteById(String id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insert(FavoriteVo favoriteVo);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<FavoriteVo> criptos);
}
