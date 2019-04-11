package net.thoitrangsi.coffeeham;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import net.thoitrangsi.coffeeham.di.AppModule;
import net.thoitrangsi.coffeeham.di.DaggerAppComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import timber.log.Timber;

/**
 * Created by thanh.le on 4/2/2019.
 */
public class BaseApplication extends Application implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> activityDispatchingAndroidInjector;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
//        MultiDex.install(base);

    }

    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
        DaggerAppComponent
                .builder()
                .application(this)
                .appModule(new AppModule(this))
                .build()
                .inject(this);

    }


    @Override
    public AndroidInjector<Activity> activityInjector() {
        return activityDispatchingAndroidInjector;
    }
}

