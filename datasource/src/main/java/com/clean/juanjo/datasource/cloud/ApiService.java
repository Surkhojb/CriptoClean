package com.clean.juanjo.datasource.cloud;

import com.clean.juanjo.datasource.cloud.model.CriptoDto;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by juanj on 11/01/2018.
 */

public interface ApiService {
    @GET("/v1/ticker/")
    Observable<List<CriptoDto>> getListCriptos(@Query("limit") String limit,
                                               @Query("convert") String convert);

    @GET("/v1/ticker/{id}")
    Observable<List<CriptoDto>> getCriptoByName(@Path("id") String name, @Query("convert") String convert);
}
