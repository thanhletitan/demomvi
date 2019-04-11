package net.thoitrangsi.coffeeham;

import android.os.Bundle;

import androidx.annotation.NonNull;

import net.thoitrangsi.ptcore.BaseFragment;
import net.thoitrangsi.ptcore.basemain.BaseMainActivity;
import net.thoitrangsi.ptcore.BaseView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseMainActivity<BaseView,MainPresenter>  {

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

    @Override
    protected void initView() {

    }

    @NonNull
    @Override
    public MainPresenter createPresenter() {
        return new MainPresenter();
    }

}
