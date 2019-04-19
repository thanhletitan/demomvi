package net.thoitrangsi.coffeeham.di.examplemodule;

import net.thoitrangsi.coffeeham.ExampleFragment;
import net.thoitrangsi.coffeeham.example.ListFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by thanh.le on 4/16/2019.
 */
@Module
public abstract class MainFragmentModule {

    @ContributesAndroidInjector
    abstract ExampleFragment providerExampleFragment();

    @ContributesAndroidInjector
    abstract ListFragment providerListFragment();
}
