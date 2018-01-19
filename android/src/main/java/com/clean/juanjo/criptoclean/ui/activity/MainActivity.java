package com.clean.juanjo.criptoclean.ui.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.clean.juanjo.criptoclean.CriptoApp;
import com.clean.juanjo.criptoclean.R;

import com.clean.juanjo.criptoclean.di.component.DaggerMainActivityComponent;
import com.clean.juanjo.criptoclean.ui.fragment.FavoriteFragment;
import com.clean.juanjo.criptoclean.ui.fragment.SettingsFragment;
import com.clean.juanjo.criptoclean.ui.fragment.TopFragment;
import com.clean.juanjo.domain.model.event.OnRefresh;
import com.clean.juanjo.domain.model.event.OnSearchCripto;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    @BindView(R.id.navigation)
    BottomNavigationView bottomNavigationView;

    @Inject
    EventBus eventBus;

    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        injectDependencies();
        initView();

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navigation_top:
                loadFragment(new TopFragment(), TopFragment.TAG);
                return true;
            case R.id.navigation_favorite:
                loadFragment(new FavoriteFragment(), FavoriteFragment.TAG);
                return true;
            case R.id.navigation_settings:
                loadFragment(new SettingsFragment(),SettingsFragment.TAG);
                return true;
        }
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        MenuItem actionSearch = menu.findItem(R.id.action_search);
        searchView = (SearchView) actionSearch.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                eventBus.post(new OnSearchCripto(query,"EUR"));
                clearSearchView();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){

            case R.id.action_refresh:
                eventBus.post(new OnRefresh());
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    private void injectDependencies() {
        CriptoApp app = (CriptoApp) getApplication();
        DaggerMainActivityComponent.builder()
                .criptoAppComponent(app.getAppComponent())
                .build()
                .inject(this);
    }

    void initView(){
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        getSupportActionBar();
        loadFragment(new TopFragment(), TopFragment.TAG);
    }

    void clearSearchView() {
        searchView.clearFocus();
        searchView.onActionViewCollapsed();
    }

    void loadFragment(Fragment f, String tag) {
        if (getSupportFragmentManager().findFragmentByTag(tag) == null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.main_content, f, tag);
            fragmentTransaction.commit();
        }
    }
}
