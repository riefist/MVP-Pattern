package com.muhamadarief.ngulikmvppattern.presenter.main;

import com.muhamadarief.ngulikmvppattern.model.EmployeeModel;
import com.muhamadarief.ngulikmvppattern.model.User;
import com.muhamadarief.ngulikmvppattern.model.service.ApiService;
import com.muhamadarief.ngulikmvppattern.views.main.MainView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by riefist on 1/3/18.
 */

public class MainPresenterImpl implements MainPresenter<MainView> {

    private MainView view;
    private ApiService mApiService;

    public MainPresenterImpl(ApiService mApiService) {
        this.mApiService = mApiService;
    }

    @Override
    public void onAttach(MainView view) {
        this.view = view;
    }

    @Override
    public void onDetach() {
        view = null;
    }

    @Override
    public void loadDataEmployee() {
        mApiService.getListCountry(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                EmployeeModel employeeModel = (EmployeeModel) response.body();
                view.onShowEmployee(employeeModel);
                view.hideProggressBar();
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                view.onFailureGetData("Failure retrive from server");
            }
        });

    }

    @Override
    public void showUser(User user) {
        view.onShowUser(user);
    }
}
