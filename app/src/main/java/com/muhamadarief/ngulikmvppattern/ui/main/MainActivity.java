package com.muhamadarief.ngulikmvppattern.ui.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.muhamadarief.ngulikmvppattern.MyApp;
import com.muhamadarief.ngulikmvppattern.R;
import com.muhamadarief.ngulikmvppattern.adapter.DataAdapter;
import com.muhamadarief.ngulikmvppattern.deps.provider.ApplicationProvider;
import com.muhamadarief.ngulikmvppattern.model.Android;
import com.muhamadarief.ngulikmvppattern.model.User;
import com.muhamadarief.ngulikmvppattern.network.ApiService;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainView, DataAdapter.OnItemClickListener {

    @Inject ApiService service;

    private MainPresenterImpl presenter;
    private RecyclerView recyclerView;
    private DataAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((ApplicationProvider)this.getApplication()).providesApplicationComponent().inject(this);
        initPresenter();
        onAttachView();
    }

    private void initPresenter(){
        presenter = new MainPresenterImpl();
    }

    @Override
    public void onAttachView() {
        presenter.onAttach(this);
        onGetUser();
        initRecyclerView();
    }

    @Override
    public void onDetachView() {
        presenter.onDetach();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.loadListAndroid(service);
    }

    @Override
    protected void onDestroy() {
        onDetachView();
        super.onDestroy();
    }

    private void initRecyclerView(){
        adapter = new DataAdapter(this);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onShowListAndroid(List<Android> androidList) {
        adapter.setListAndroid(androidList);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onFailureGetData(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onGetUser() {
        User user = getIntent().getParcelableExtra("user");
        presenter.showUser(user);
    }

    @Override
    public void onShowUser(User user) {
        Toast.makeText(this, ""+user.getEmail(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void hideProggressBar() {
        ProgressBar progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.GONE);
    }


    @Override
    public void onItemClicked(Android android) {
        Toast.makeText(this, android.getName(), Toast.LENGTH_SHORT).show();
    }
}
