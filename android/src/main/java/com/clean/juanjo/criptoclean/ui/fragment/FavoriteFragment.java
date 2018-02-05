package com.clean.juanjo.criptoclean.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.clean.juanjo.criptoclean.CriptoApp;
import com.clean.juanjo.criptoclean.R;
import com.clean.juanjo.criptoclean.di.component.DaggerFavoriteFragmentComponent;
import com.clean.juanjo.criptoclean.di.module.FavoriteFragmentModule;
import com.clean.juanjo.criptoclean.ui.adapter.FavoriteCurrencyAdapter;
import com.clean.juanjo.presentation.favoritefragment.FavoriteFragmentContract;
import com.clean.juanjo.presentation.base.model.Cripto;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class FavoriteFragment extends Fragment implements FavoriteFragmentContract.View{

    public static final String TAG = "FavoriteFragment";
    //TODO: TEST THE INSERT AND GET FAVORITES

    @BindView(R.id.rv_cripto_list)
    RecyclerView listOfFavorites;
    @BindView(R.id.progress_loading_list)
    ProgressBar loadingFavorites;

    @Inject
    FavoriteFragmentContract.Presenter presenter;

    FavoriteCurrencyAdapter listAdapter;

    public FavoriteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_favorite, container, false);
        ButterKnife.bind(this,v);
        injectDependencies();
        initRecyclerView();
        presenter.loadFavorites();
        return v;
    }

    @Override
    public void showListOfFavorites(List<Cripto> criptos) {
        if(!criptos.isEmpty())
            listAdapter.refreshData(criptos);
        listOfFavorites.setVisibility(View.VISIBLE);
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(getContext(),message,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showError(String errorMessage) {
        Toast.makeText(getContext(),errorMessage,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoading(boolean status) {
        if(status){
            loadingFavorites.setVisibility(View.VISIBLE);
            listOfFavorites.setVisibility(View.GONE);
        }else{
            loadingFavorites.setVisibility(View.GONE);
            listOfFavorites.setVisibility(View.VISIBLE);
        }
    }

    private void initRecyclerView() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        listOfFavorites.setHasFixedSize(true);
        listOfFavorites.setLayoutManager(layoutManager);
        listAdapter = new FavoriteCurrencyAdapter();
        listOfFavorites.setAdapter(listAdapter);
    }

    private void injectDependencies() {
        CriptoApp app = (CriptoApp) getActivity().getApplication();

        DaggerFavoriteFragmentComponent.builder()
                .criptoAppComponent(app.getAppComponent())
                .favoriteFragmentModule(new FavoriteFragmentModule(this))
                .build()
                .inject(this);
    }
}
