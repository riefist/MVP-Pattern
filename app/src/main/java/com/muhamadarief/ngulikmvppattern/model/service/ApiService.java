package com.muhamadarief.ngulikmvppattern.model.service;

import android.content.Context;

import com.muhamadarief.ngulikmvppattern.BuildConfig;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by riefist on 12/19/17.
 */

public class ApiService {

    private ApiInterface mApiInterface;
    private Retrofit retrofit;

    public ApiService(Context context) {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .client(builder())
                    .baseUrl(Config.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            mApiInterface = retrofit.create(ApiInterface.class);

        }
    }

    private OkHttpClient builder() {
        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
        okHttpClient.connectTimeout(20, TimeUnit.SECONDS);
        okHttpClient.writeTimeout(20, TimeUnit.SECONDS);
        okHttpClient.readTimeout(90, TimeUnit.SECONDS);

        if (BuildConfig.DEBUG) {
            okHttpClient.addInterceptor(interceptor());
        }

        return okHttpClient.build();
    }

    private HttpLoggingInterceptor interceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return interceptor;
    }

    public void getListCountry(Callback callback){
        mApiInterface.getEmployee().enqueue(callback);
    }


}
