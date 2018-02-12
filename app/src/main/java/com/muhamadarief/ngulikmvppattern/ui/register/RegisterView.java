package com.muhamadarief.ngulikmvppattern.ui.register;

import com.muhamadarief.ngulikmvppattern.ui.base.BaseView;
import com.muhamadarief.ngulikmvppattern.model.User;

/**
 * Created by riefist on 1/3/18.
 */

public interface RegisterView extends BaseView {

    void onSuccess(User user);
    void onFailed(String message);

}
