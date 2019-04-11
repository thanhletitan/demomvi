package net.thoitrangsi.coffeeham;

import android.os.Bundle;

import net.thoitrangsi.ptcore.BaseFragment;
import net.thoitrangsi.ptcore.basemain.BaseMainActivity;
import net.thoitrangsi.ptcore.BaseView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;

/**
 * Created by thanh.le on 4/2/2019.
 */
public class SubActivity extends BaseMainActivity<BaseView,MainPresenter>{
    @NonNull
    @Override
    public MainPresenter createPresenter() {
        return new MainPresenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_sub);
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

}
