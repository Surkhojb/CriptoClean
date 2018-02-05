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
import com.clean.juanjo.criptoclean.di.component.DaggerTopFragmentComponent;
import com.clean.juanjo.criptoclean.di.module.TopFragmentModule;
import com.clean.juanjo.criptoclean.ui.adapter.CriptoAdapterListener;
import com.clean.juanjo.criptoclean.ui.adapter.CriptoCurrencyAdapter;
import com.clean.juanjo.criptoclean.ui.adapter.CriptoTouchListener;
import com.clean.juanjo.domain.model.event.OnRefresh;
import com.clean.juanjo.domain.model.event.OnSearchCripto;
import com.clean.juanjo.presentation.topfragment.TopFragmentContract;
import com.clean.juanjo.presentation.base.model.Cripto;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import javax.annotation.Nullable;
import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TopFragment extends Fragment implements TopFragmentContract.View,CriptoAdapterListener{

    public static final String TAG = "TopFragment";

    @BindView(R.id.rv_cripto_list)
    RecyclerView listOfCriptos;
    @BindView(R.id.progress_loading_list)
    ProgressBar loadingProgress;

    @Inject
    TopFragmentContract.Presenter presenter;
    @Inject
    EventBus eventBus;

    CriptoCurrencyAdapter listAdapter;

    public TopFragment() {
        // Required empty public constructor
    }


    //region Override methods
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_top, container, false);
        ButterKnife.bind(this,v);
        injectDependencies();
        initRecyclerView();
        presenter.loadCriptos();
        return v;
    }

    @Override public void onStart() {
        super.onStart();
        eventBus.register(this);
    }

    @Override public void onStop() {
        eventBus.unregister(this);
        super.onStop();
    }

    @Override
    public void showLoading(boolean status) {
        if(status){
            loadingProgress.setVisibility(View.VISIBLE);
            listOfCriptos.setVisibility(View.GONE);
        }else{
            loadingProgress.setVisibility(View.GONE);
            listOfCriptos.setVisibility(View.VISIBLE);
        }
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
    public void showListOfCriptos(List<Cripto> criptos) {
        if(!criptos.isEmpty())
            listAdapter.refreshData(criptos);
        listOfCriptos.setVisibility(View.VISIBLE);
    }

    @Override
    public void onClick(View view, int position) {

    }

    @Override
    public void onLongClick(View view, int position) {
        System.out.println("FAV Item clicked: "+listAdapter.getItem(position).getId());
        presenter.addToFavorites(listAdapter.getItem(position));
    }

    //endregion

    //region Methods
    private void initRecyclerView() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        listOfCriptos.setHasFixedSize(true);
        listOfCriptos.setLayoutManager(layoutManager);
        listOfCriptos.addOnItemTouchListener(new CriptoTouchListener(
                getContext(), listOfCriptos,this));

        listAdapter = new CriptoCurrencyAdapter();
        listOfCriptos.setAdapter(listAdapter);
    }
    private void injectDependencies() {
        CriptoApp app = (CriptoApp) getActivity().getApplication();

        DaggerTopFragmentComponent.builder()
                .criptoAppComponent(app.getAppComponent())
                .topFragmentModule(new TopFragmentModule(this))
                .build()
                .inject(this);
    }

    //endregion

    //region Bus events
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onSearchCripto(OnSearchCripto searchCripto){
      presenter.loadCriptosByName(searchCripto.getName());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onRefresh(OnRefresh onRefresh){
        presenter.loadCriptos();
    }

    //endregion

}
