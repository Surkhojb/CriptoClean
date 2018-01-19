package com.clean.juanjo.criptoclean.di.module;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.content.SharedPreferences;

import com.clean.juanjo.criptoclean.CriptoApp;
import com.clean.juanjo.criptoclean.domain.MainThreadImpl;
import com.clean.juanjo.datasource.cloud.RestApiDatasource;
import com.clean.juanjo.datasource.local.db.CriptoDatabase;
import com.clean.juanjo.datasource.local.db.LocalDatasource;
import com.clean.juanjo.datasource.local.db.favorite.FavoriteDao;
import com.clean.juanjo.datasource.local.db.favorite.model.FavoriteVo;
import com.clean.juanjo.datasource.local.db.top.CriptoDao;
import com.clean.juanjo.datasource.local.preference.PreferencesManager;
import com.clean.juanjo.domain.executor.JobExecutor;
import com.clean.juanjo.domain.executor.MainThread;
import com.clean.juanjo.domain.executor.ThreadExecutor;
import com.clean.juanjo.domain.repository.CriptoRepository;
import com.clean.juanjo.repository.datasource.cloud.ApiDatasource;
import com.clean.juanjo.repository.datasource.CriptoCleanRepository;
import com.clean.juanjo.repository.datasource.local.ILocalDataSource;
import com.clean.juanjo.repository.datasource.local.ISettingsPreferences;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by juanj on 11/01/2018.
 */

@Module
public class CriptoAppModule {
    private static final String DB_NAME = "cripto_database";
    private static final String PREFERENCES = "cripto_preferences";

    private CriptoApp app;

    public CriptoAppModule(CriptoApp app) {
        this.app = app;
    }

    @Provides
    @Singleton
    CriptoApp providesCriptoApp(){
        return app;
    }

    @Provides
    @Singleton
    ThreadExecutor providesThreadExecutor(JobExecutor jobExecutor){
        return jobExecutor;

    }

    @Provides
    @Singleton
    MainThread provideMainThread(MainThreadImpl mainThread){
        return mainThread;
    }

    @Provides
    @Singleton
    ApiDatasource provideApiDatasource(RestApiDatasource restApiDatasource){
        return restApiDatasource;
    }

    @Provides
    @Singleton
    ILocalDataSource provideLocalDataSource(LocalDatasource localDatasource){
        return localDatasource;
    }

    @Provides
    @Singleton
    CriptoRepository provideApiRepository(CriptoCleanRepository restApiRepository){
        return restApiRepository;
    }

    @Provides
    @Singleton
    EventBus provideEventBus(){
        return EventBus.getDefault();
    }

    @Provides
    @Singleton
    CriptoDatabase providesCriptoDatabase(){
        return Room.databaseBuilder(app.getApplicationContext(),CriptoDatabase.class,DB_NAME).build();
    }

    @Provides
    @Singleton
    CriptoDao providesCriptoDao(CriptoDatabase database){
        return database.criptoDao();
    }

    @Provides
    @Singleton
    FavoriteDao providesFavoriteDao(CriptoDatabase database){
        return database.favoriteDao();
    }

    @Provides
    @Singleton
    SharedPreferences providePreferences(){
        return app.getApplicationContext().getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE);
    }

    @Provides
    @Singleton
    ISettingsPreferences providePreferencesManager(){
        return new PreferencesManager(providePreferences());
    }

}
