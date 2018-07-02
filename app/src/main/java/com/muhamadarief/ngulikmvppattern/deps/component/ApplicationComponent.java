package com.muhamadarief.ngulikmvppattern.deps.component;

import com.muhamadarief.ngulikmvppattern.deps.module.NetworkModule;
import com.muhamadarief.ngulikmvppattern.deps.module.ServiceModule;
import com.muhamadarief.ngulikmvppattern.ui.main.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {NetworkModule.class, ServiceModule.class})
public interface ApplicationComponent {
    void inject(MainActivity mainActivity);
}
