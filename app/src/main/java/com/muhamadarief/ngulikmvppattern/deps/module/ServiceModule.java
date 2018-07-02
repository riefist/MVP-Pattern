package com.muhamadarief.ngulikmvppattern.deps.module;

import com.muhamadarief.ngulikmvppattern.network.ApiInterface;
import com.muhamadarief.ngulikmvppattern.network.ApiService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ServiceModule {

    @Provides
    @Singleton
    protected ApiService providesAndroidService(ApiInterface apiInterface){
        return new ApiService(apiInterface);
    }
}
