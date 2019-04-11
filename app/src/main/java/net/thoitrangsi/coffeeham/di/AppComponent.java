package net.thoitrangsi.coffeeham.di;

import android.app.Application;

import net.thoitrangsi.coffeeham.BaseApplication;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

/**
 * Created by thanh.le on 4/2/2019.
 */
@Singleton
@Component(modules = {AppModule.class,
        AndroidInjectionModule.class,ActivityBuilder.class})
public interface AppComponent {
    // Get Shared Pref.
    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);
        Builder appModule(AppModule module);
        AppComponent build();

    }
    void inject(BaseApplication app);

//    PreferenceStore preStore();
}
