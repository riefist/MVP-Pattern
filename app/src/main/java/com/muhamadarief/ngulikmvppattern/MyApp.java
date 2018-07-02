package com.muhamadarief.ngulikmvppattern;

import android.app.Application;

import com.muhamadarief.ngulikmvppattern.deps.component.ApplicationComponent;
import com.muhamadarief.ngulikmvppattern.deps.component.DaggerApplicationComponent;
import com.muhamadarief.ngulikmvppattern.deps.module.NetworkModule;
import com.muhamadarief.ngulikmvppattern.deps.module.ServiceModule;
import com.muhamadarief.ngulikmvppattern.deps.provider.ApplicationProvider;

public class MyApp extends Application implements ApplicationProvider{
    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent.builder()
                .networkModule(new NetworkModule(this))
                .serviceModule(new ServiceModule())
                .build();
    }

    @Override
    public ApplicationComponent providesApplicationComponent() {
        return applicationComponent;
    }
}
