package net.thoitrangsi.coffeeham.di;

import net.thoitrangsi.coffeeham.MainActivity;
import net.thoitrangsi.coffeeham.SubActivity;
import net.thoitrangsi.coffeeham.di.examplemodule.MainFragmentModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by thanh.le on 4/2/2019.
 */
@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = MainFragmentModule.class)
    abstract MainActivity bindMainActivity();

    @ContributesAndroidInjector
    abstract SubActivity bindSubActivity();

}
