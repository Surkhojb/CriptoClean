package com.clean.juanjo.domain.interactor;

import com.clean.juanjo.domain.executor.MainThread;
import com.clean.juanjo.domain.executor.ThreadExecutor;
import com.clean.juanjo.domain.model.CriptoModel;
import com.clean.juanjo.domain.repository.CriptoRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by juanj on 11/01/2018.
 */

public class GetCriptoByNameUseCase extends UseCase<List<CriptoModel>,GetCriptoByNameUseCase.Params> {

    CriptoRepository criptoRepository;

    @Inject
    public GetCriptoByNameUseCase(ThreadExecutor threadExecutor, MainThread mainThread
            , CriptoRepository repository){
        super(threadExecutor,mainThread);
        this.criptoRepository = repository;

    }

    @Override
    Observable<List<CriptoModel>> buildUseCaseObservable(Params params) {
        String name = params.name.toLowerCase();
        return criptoRepository.getCriptoByName(name);
    }


    public static final class Params {
        private String name;

        private Params(String num){
            this.name = num;
        }

        public static GetCriptoByNameUseCase.Params create(String name){
            return new Params(name);
        }

    }
}
