package com.muhamadarief.ngulikmvppattern.ui.register;

import android.text.TextUtils;

import com.muhamadarief.ngulikmvppattern.model.User;

/**
 * Created by riefist on 1/3/18.
 */

public class RegisterPresenterImpl implements RegisterPresenter<RegisterView> {

    private RegisterView view;

    @Override
    public void onAttach(RegisterView view) {
        this.view = view;
    }

    @Override
    public void onDetach() {
        view = null;
    }

    @Override
    public void registerUser(String email, String password) {
        if (!TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)){
            User user = new User(email, password);
            view.onSuccess(user);
        } else {
            view.onFailed("Register Failed");
        }
    }
}
