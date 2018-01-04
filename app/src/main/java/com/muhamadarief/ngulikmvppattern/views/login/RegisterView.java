package com.muhamadarief.ngulikmvppattern.views.login;

import com.muhamadarief.ngulikmvppattern.base.BaseView;
import com.muhamadarief.ngulikmvppattern.model.User;

/**
 * Created by riefist on 1/3/18.
 */

public interface RegisterView extends BaseView {

    void onSuccess(User user);
    void onFailed(String message);

}
