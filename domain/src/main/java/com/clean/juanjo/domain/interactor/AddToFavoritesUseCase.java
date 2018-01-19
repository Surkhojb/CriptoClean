package com.clean.juanjo.domain.interactor;

import com.clean.juanjo.domain.executor.MainThread;
import com.clean.juanjo.domain.executor.ThreadExecutor;
import com.clean.juanjo.domain.model.CriptoModel;
import com.clean.juanjo.domain.repository.CriptoRepository;

import javax.inject.Inject;

import io.reactivex.Observable;


/**
 * Created by juanj on 18/01/2018.
 */

public class AddToFavoritesUseCase extends UseCase<Boolean,AddToFavoritesUseCase.Params>{

    CriptoRepository criptoRepository;

    @Inject
    public AddToFavoritesUseCase(ThreadExecutor threadExecutor, MainThread mainThread,
                                 CriptoRepository criptoRepository){
        super(threadExecutor,mainThread);
        this.criptoRepository = criptoRepository;
    }

    @Override
    Observable<Boolean> buildUseCaseObservable(AddToFavoritesUseCase.Params params) {
        CriptoModel model = params.model;
        System.out.println("FAV Usecase: "+model.getId());
        boolean saved = criptoRepository.addToFavorites(params.model);
        return Observable.just(saved);
    }

    public static final class Params {
        private CriptoModel model;

        private Params(){}

        private Params(CriptoModel model){
            this.model = model;
        }

        public static AddToFavoritesUseCase.Params create(CriptoModel model){
            return new AddToFavoritesUseCase.Params(model);
        }

        public static AddToFavoritesUseCase.Params create(){
            return new AddToFavoritesUseCase.Params();
        }

    }

}
