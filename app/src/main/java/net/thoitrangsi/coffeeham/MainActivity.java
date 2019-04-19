package net.thoitrangsi.coffeeham;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

import net.thoitrangsi.ptcore.BaseFragment;
import net.thoitrangsi.ptcore.HeaderView;
import net.thoitrangsi.ptcore.basemain.BaseMainActivity;
import net.thoitrangsi.ptcore.BaseView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class MainActivity extends BaseMainActivity<BaseView,MainPresenter> implements HasSupportFragmentInjector {

    @Inject
    DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;


    @Override
    protected HeaderView setHeader() {
        return new HeaderView(this).Builder()
                .setTitle("MainActivity")
                .build();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected List<BaseFragment> addListFragments() {
        List<BaseFragment> fragments = new ArrayList<>();
        fragments.add(new ExampleFragment());
        fragments.add(new ExampleFragment());
        fragments.add(new ExampleFragment());
        return fragments;
    }


    @NonNull
    @Override
    public MainPresenter createPresenter() {
        return new MainPresenter();
    }


    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentDispatchingAndroidInjector;
    }
}
