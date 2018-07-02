package com.muhamadarief.ngulikmvppattern.network;

public interface NetworkCallback<T> {
    void onSuccess(T response);
    void onError(Throwable e);
}
