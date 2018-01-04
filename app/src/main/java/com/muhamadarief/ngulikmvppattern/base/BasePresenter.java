package com.muhamadarief.ngulikmvppattern.base;

/**
 * Created by riefist on 1/3/18.
 */

public interface BasePresenter<V> {
    void onAttach(V view);
    void onDetach();
}
