package com.muhamadarief.ngulikmvppattern.ui.main;

import com.muhamadarief.ngulikmvppattern.model.Android;
import com.muhamadarief.ngulikmvppattern.ui.base.BaseView;
import com.muhamadarief.ngulikmvppattern.model.User;

import java.util.List;

/**
 * Created by riefist on 1/3/18.
 */

public interface MainView extends BaseView {
    void onShowListAndroid(List<Android> androidList);
    void onFailureGetData(String message);
    void onGetUser();
    void onShowUser(User user);
    void hideProggressBar();
}
