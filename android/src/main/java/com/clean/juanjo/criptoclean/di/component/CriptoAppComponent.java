package com.clean.juanjo.criptoclean.di.component;

import com.clean.juanjo.criptoclean.CriptoApp;
import com.clean.juanjo.criptoclean.di.module.CriptoAppModule;
import com.clean.juanjo.criptoclean.di.module.DataSourceModule;
import com.clean.juanjo.domain.executor.MainThread;
import com.clean.juanjo.domain.executor.ThreadExecutor;
import com.clean.juanjo.domain.repository.CriptoRepository;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Singleton;
import dagger.Component;
/**
 * Created by juanj on 11/01/2018.
 */

@Singleton
@Component(modules = {DataSourceModule.class, CriptoAppModule.class})
public interface CriptoAppComponent {
    void inject(CriptoApp app);

    ThreadExecutor threadExecutor();

    MainThread mainThread();

    CriptoRepository apiRepository();

    EventBus provideEventBus();
}
