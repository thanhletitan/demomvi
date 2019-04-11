package net.thoitrangsi.coffeeham.di;

import android.app.Application;

import dagger.Module;

/**
 * Created by thanh.le on 4/2/2019.
 */
@Module
public class AppModule {

    // Shared Pref.

    private Application mApplication;

    public AppModule(Application application) {
        mApplication = application;
    }
}
