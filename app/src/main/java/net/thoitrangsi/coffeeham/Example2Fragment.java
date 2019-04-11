package net.thoitrangsi.coffeeham;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.thoitrangsi.coffeeham.ExamplePresenter;
import net.thoitrangsi.coffeeham.R;
import net.thoitrangsi.coffeeham.databinding.ExampleFragment2Binding;
import net.thoitrangsi.ptcore.BaseFragment;
import net.thoitrangsi.ptcore.BaseView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * Created by thanh.le on 4/1/2019.
 */
public class Example2Fragment extends BaseFragment<BaseView,ExamplePresenter, ExampleFragment2Binding> {
    @NonNull
    @Override
    public ExamplePresenter createPresenter() {
        return new ExamplePresenter();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(),container,false);
        return view;
    }

    @Override
    public void initView() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.example_fragment2;
    }
}
