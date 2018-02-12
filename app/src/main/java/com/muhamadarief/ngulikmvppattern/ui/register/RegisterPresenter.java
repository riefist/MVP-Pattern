package com.muhamadarief.ngulikmvppattern.ui.register;

import com.muhamadarief.ngulikmvppattern.ui.base.BasePresenter;

/**
 * Created by riefist on 1/3/18.
 */

public interface RegisterPresenter<V> extends BasePresenter<V> {

    void registerUser(String email, String password);

}
