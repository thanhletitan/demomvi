package net.thoitrangsi.coffeeham;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.jakewharton.rxbinding3.view.RxView;

import net.thoitrangsi.coffeeham.example.ListFragment;
import net.thoitrangsi.ptcore.BaseFragment;
import net.thoitrangsi.ptcore.basemain.BaseMainPresenter;
import net.thoitrangsi.ptcore.BaseState;
import net.thoitrangsi.ptcore.BaseView;
import net.thoitrangsi.ptcore.databinding.ExampleFragmentBinding;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import io.reactivex.Observable;
import timber.log.Timber;

/**
 * Created by thanh.le on 4/1/2019.
 */
public class ExampleFragment extends BaseFragment<BaseView, BaseMainPresenter,ExampleFragmentBinding> implements BaseView{

    @NonNull
    @Override
    public BaseMainPresenter createPresenter() {
        return new BaseMainPresenter(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        binding = DataBindingUtil.bind(view);
        binding.executePendingBindings();
        return binding.getRoot();
    }

    @Override
    public void initView() {

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        binding.txtExm1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////               pushFragmentStack(new Example2Fragment(),
////                        R.id.frame_fragment);
//                Intent i = new Intent(baseActivity,SubActivity.class);
//                baseActivity.startActivity(i);
//            }
//        });
    }

    @Override
    public Observable<Boolean> click() {
        return RxView.clicks(binding.txtExm1).map( click-> true);
    }

    @Override
    public Observable<Boolean> click2() {
        return RxView.clicks(binding.txtExm2).map( click-> true);
    }

    @Override
    public void render(BaseState state) {
        Timber.e("new state");
    }

    @Override
    public void navigator(Object action, Object... params) {
        super.navigator(action, params);
        NavigatorAction navigatorAction = (NavigatorAction) action;
        switch (navigatorAction){
            case GO_MAIN:
                Intent i = new Intent(baseActivity,SubActivity.class);
                baseActivity.startActivity(i);
                break;
            case GO_FRAGMENT:
                pushFragmentStack(new ListFragment(),
                        R.id.frame_fragment);
                break;
        }
    }
}
