package com.muhamadarief.ngulikmvppattern.ui.main;

import com.muhamadarief.ngulikmvppattern.model.Android;
import com.muhamadarief.ngulikmvppattern.model.User;
import com.muhamadarief.ngulikmvppattern.network.ApiService;
import com.muhamadarief.ngulikmvppattern.network.NetworkCallback;

import java.util.List;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

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
    public void loadListAndroid(ApiService service) {
        Disposable disposable = service.androidVersion(new NetworkCallback<List<Android>>() {
            @Override
            public void onSuccess(List<Android> response) {
                view.onShowListAndroid(response);
                view.hideProggressBar();
            }

            @Override
            public void onError(Throwable e) {
                view.onFailureGetData(e.toString());
            }
        });
        compositeDisposable.add(disposable);
    }

    @Override
    public void showUser(User user) {
        view.onShowUser(user);
    }

}
