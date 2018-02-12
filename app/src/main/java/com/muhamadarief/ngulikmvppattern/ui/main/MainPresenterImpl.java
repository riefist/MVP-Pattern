package com.muhamadarief.ngulikmvppattern.ui.main;

import android.widget.Toast;

import com.muhamadarief.ngulikmvppattern.model.Android;
import com.muhamadarief.ngulikmvppattern.model.User;
import com.muhamadarief.ngulikmvppattern.network.ApiClient;
import com.muhamadarief.ngulikmvppattern.network.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by riefist on 1/3/18.
 */

public class MainPresenterImpl implements MainPresenter<MainView> {

    private MainView view;
    private CompositeDisposable compositeDisposable;

    MainPresenterImpl() {
    }

    @Override
    public void onAttach(MainView view) {
        this.view = view;
        compositeDisposable = new CompositeDisposable();
    }

    @Override
    public void onDetach() {
        view = null;
        compositeDisposable.clear();
    }

    @Override
    public void loadListAndroid() {
        ApiInterface apiInterface = ApiClient.getAPIService();
        compositeDisposable.add(apiInterface.listAndroid()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::handleResponse, this::handleError));
    }

    @Override
    public void showUser(User user) {
        view.onShowUser(user);
    }

    @Override
    public void handleResponse(List<Android> androids) {
        view.onShowListAndroid(androids);
        view.hideProggressBar();
    }

    @Override
    public void handleError(Throwable error) {
        view.onFailureGetData(error.toString());
    }
}
