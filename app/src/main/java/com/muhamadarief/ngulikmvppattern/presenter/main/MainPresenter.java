package com.muhamadarief.ngulikmvppattern.presenter.main;

import com.muhamadarief.ngulikmvppattern.base.BasePresenter;
import com.muhamadarief.ngulikmvppattern.model.User;

/**
 * Created by riefist on 1/3/18.
 */

public interface MainPresenter<V> extends BasePresenter<V> {

    void loadDataEmployee();
    void showUser(User user);
}
