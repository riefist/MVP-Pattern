package com.muhamadarief.ngulikmvppattern.network;

import com.muhamadarief.ngulikmvppattern.model.Android;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.observers.DefaultObserver;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

public class ApiService {

    private ApiInterface apiInterface;

    public ApiService(ApiInterface apiInterface) {
        this.apiInterface = apiInterface;
    }

    public Disposable androidVersion(NetworkCallback<List<Android>> callback) {
        return apiInterface.listAndroid()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(
                        callback::onSuccess,
                        callback::onError
                );

    }

}
