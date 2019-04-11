package net.thoitrangsi.coffeeham.di;

import net.thoitrangsi.coffeeham.MainActivity;
import net.thoitrangsi.coffeeham.SubActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by thanh.le on 4/2/2019.
 */
@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector
    abstract MainActivity bindMainActivity();

    @ContributesAndroidInjector
    abstract SubActivity bindSubActivity();

}
