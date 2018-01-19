package com.clean.juanjo.criptoclean.domain;

import com.clean.juanjo.domain.executor.MainThread;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;

/**
 * Created by juanj on 11/01/2018.
 */

@Singleton
public class MainThreadImpl implements MainThread {

    @Inject
    public MainThreadImpl(){}

    @Override
    public Scheduler getScheduler() {
        return AndroidSchedulers.mainThread();
    }
}
