package com.muhamadarief.ngulikmvppattern.views.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.muhamadarief.ngulikmvppattern.R;
import com.muhamadarief.ngulikmvppattern.adapter.UserRecyclerAdapter;
import com.muhamadarief.ngulikmvppattern.model.EmployeeModel;
import com.muhamadarief.ngulikmvppattern.model.User;
import com.muhamadarief.ngulikmvppattern.model.service.ApiService;
import com.muhamadarief.ngulikmvppattern.presenter.main.MainPresenterImpl;

public class MainActivity extends AppCompatActivity implements MainView, UserRecyclerAdapter.OnItemClickListener {

    private MainPresenterImpl presenter;
    private RecyclerView recyclerView;
    private UserRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initPresenter();
        onAttachView();
    }

    private void initPresenter(){
        presenter = new MainPresenterImpl(new ApiService(this));
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
        presenter.loadDataEmployee();
    }

    @Override
    protected void onDestroy() {
        onDetachView();
        super.onDestroy();
    }

    private void initRecyclerView(){
        adapter = new UserRecyclerAdapter(this);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }


    @Override
    public void onItemClick(EmployeeModel.Data user) {
        Toast.makeText(this, ""+user.getName(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onShowEmployee(EmployeeModel employeeModel) {
        adapter.replaceData(employeeModel.getData());
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


}
