package com.muhamadarief.ngulikmvppattern.ui.main;

import com.muhamadarief.ngulikmvppattern.model.Android;
import com.muhamadarief.ngulikmvppattern.network.ApiService;
import com.muhamadarief.ngulikmvppattern.ui.base.BasePresenter;
import com.muhamadarief.ngulikmvppattern.model.User;

import java.util.List;

/**
 * Created by riefist on 1/3/18.
 */

public interface MainPresenter<V> extends BasePresenter<V> {

    void loadListAndroid(ApiService service);
    void showUser(User user);
}
