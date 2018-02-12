package com.muhamadarief.ngulikmvppattern.network;

import com.muhamadarief.ngulikmvppattern.model.Android;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by riefist on 12/19/17.
 */

public interface ApiInterface {

    @GET("android/jsonarray/")
    Observable<List<Android>> listAndroid();

}
