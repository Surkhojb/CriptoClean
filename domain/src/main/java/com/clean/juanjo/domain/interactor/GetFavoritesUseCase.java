package com.clean.juanjo.domain.interactor;

import com.clean.juanjo.domain.executor.MainThread;
import com.clean.juanjo.domain.executor.ThreadExecutor;
import com.clean.juanjo.domain.model.CriptoModel;
import com.clean.juanjo.domain.repository.CriptoRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by juanj on 19/01/2018.
 */

public class GetFavoritesUseCase extends UseCase<List<CriptoModel>,GetFavoritesUseCase.Params> {
    CriptoRepository criptoRepository;

    @Inject
    public GetFavoritesUseCase(ThreadExecutor threadExecutor, MainThread mainThread
            , CriptoRepository repository){
        super(threadExecutor,mainThread);
        this.criptoRepository = repository;

    }

    @Override
    Observable<List<CriptoModel>> buildUseCaseObservable(GetFavoritesUseCase.Params params) {
        System.out.println("FAV Get favorites");
        return criptoRepository.getFavorites();
    }


    public static final class Params {
        private String num,convert;

        private Params(){}

        private Params(String num,String convert){
            this.num = num;
            this.convert =  convert;
        }

        public static GetFavoritesUseCase.Params create(String num,String convert){
            return new GetFavoritesUseCase.Params(num,convert);
        }

        public static GetFavoritesUseCase.Params create(){
            return new GetFavoritesUseCase.Params();
        }

    }
}
