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

public class GetTopUseCase extends UseCase<List<CriptoModel>,GetTopUseCase.Params> {

    CriptoRepository criptoRepository;

    @Inject
    public GetTopUseCase(ThreadExecutor threadExecutor, MainThread mainThread
            ,CriptoRepository repository){
        super(threadExecutor,mainThread);
        this.criptoRepository = repository;

    }

    @Override
    Observable<List<CriptoModel>> buildUseCaseObservable(Params params) {
        return criptoRepository.getCriptos();
    }


    public static final class Params {
        private String num,convert;

        private Params(){}

        private Params(String num,String convert){
            this.num = num;
            this.convert =  convert;
        }

        public static GetTopUseCase.Params create(String num,String convert){
            return new Params(num,convert);
        }

        public static GetTopUseCase.Params create(){
            return new Params();
        }

    }
}
