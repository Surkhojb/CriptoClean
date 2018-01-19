package com.clean.juanjo.domain.interactor;

import com.clean.juanjo.domain.executor.MainThread;
import com.clean.juanjo.domain.executor.ThreadExecutor;
import com.clean.juanjo.domain.repository.CriptoRepository;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by juanj on 16/01/2018.
 */

public class SaveSettingsUseCase extends UseCase<Boolean,SaveSettingsUseCase.Params>{
    CriptoRepository criptoRepository;

    @Inject
    public SaveSettingsUseCase(ThreadExecutor threadExecutor, MainThread mainThread
            , CriptoRepository repository){
        super(threadExecutor,mainThread);
        this.criptoRepository = repository;

    }

    @Override
    Observable<Boolean> buildUseCaseObservable(Params params) {
        boolean saved = criptoRepository.saveCriptoAppSettings(params.num);
        return Observable.just(new Boolean(saved));
    }


    public static final class Params {
        private String num;

        private Params(){}

        private Params(String num){
            this.num = num;
        }

        public static SaveSettingsUseCase.Params create(String num){
            return new SaveSettingsUseCase.Params(num);
        }

        public static SaveSettingsUseCase.Params create(){
            return new SaveSettingsUseCase.Params();
        }

    }
}
