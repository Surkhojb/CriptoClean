package com.clean.juanjo.criptoclean.ui.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.clean.juanjo.criptoclean.CriptoApp;
import com.clean.juanjo.criptoclean.R;
import com.clean.juanjo.criptoclean.di.component.DaggerSettingsFragComponent;
import com.clean.juanjo.criptoclean.di.module.SettingsFragmentModule;
import com.clean.juanjo.presentation.settingsfragment.SettingsFragmentContract;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class SettingsFragment extends Fragment implements SettingsFragmentContract.View {
    public static final String TAG = "SettingsFragment";

    @Inject
    SettingsFragmentContract.Presenter presenter;

    @BindView(R.id.sp_num_items)
    Spinner spinner;

    String numOfItems;

    public SettingsFragment() {
        // Required empty public constructor
    }

    @NonNull
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_settings, container, false);
        ButterKnife.bind(this,v);
        injectDependencies();
        return v;
    }

    @OnClick(R.id.fab_save_settings)
    public void fabSave(View v) {
        handleValues();
        presenter.saveSettings(numOfItems);
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(getContext(),message,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showError(String errorMessage) {
        Toast.makeText(getContext(),errorMessage,Toast.LENGTH_SHORT).show();
    }

    private void injectDependencies() {
        CriptoApp app = (CriptoApp) getActivity().getApplication();

       DaggerSettingsFragComponent.builder()
                .criptoAppComponent(app.getAppComponent())
                .settingsFragmentModule(new SettingsFragmentModule(this))
                .build()
                .inject(this);
    }

    private void handleValues() {
        numOfItems = spinner.getSelectedItem().toString();
    }
}
