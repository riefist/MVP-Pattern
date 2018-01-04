package com.muhamadarief.ngulikmvppattern.views.main;

import com.muhamadarief.ngulikmvppattern.base.BaseView;
import com.muhamadarief.ngulikmvppattern.model.EmployeeModel;
import com.muhamadarief.ngulikmvppattern.model.User;

/**
 * Created by riefist on 1/3/18.
 */

public interface MainView extends BaseView {
    void onShowEmployee(EmployeeModel employeeModel);
    void onFailureGetData(String message);
    void onGetUser();
    void onShowUser(User user);
    void hideProggressBar();
}
