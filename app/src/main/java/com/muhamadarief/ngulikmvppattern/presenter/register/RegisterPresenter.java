package com.muhamadarief.ngulikmvppattern.presenter.register;

import com.muhamadarief.ngulikmvppattern.base.BasePresenter;
import com.muhamadarief.ngulikmvppattern.base.BaseView;

/**
 * Created by riefist on 1/3/18.
 */

public interface RegisterPresenter<V> extends BasePresenter<V> {

    void registerUser(String email, String password);

}
