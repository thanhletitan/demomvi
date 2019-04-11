package net.thoitrangsi.ptcore;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hannesdorfmann.mosby3.mvi.MviFragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

/**
 * Created by thanh.le on 4/1/2019.
 */
public abstract class BaseFragment<V extends BaseView, P extends BasePresenter<V, ?>,VB extends ViewDataBinding> extends MviFragment<V,P> implements NavigatorView {

    protected BaseActivity baseActivity;
    protected View view;
    protected VB binding;
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.baseActivity = (BaseActivity) activity;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(view == null){
            view = inflater.inflate(getLayoutId(),container,false);
            binding = DataBindingUtil.bind(view);
            binding.executePendingBindings();
            initView();
        }
        return binding.getRoot();
    }
    public abstract void initView();
    @Override
    public void onDestroyView() {
        if (view != null && view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        binding.unbind();
        super.onDestroyView();
    }
    public int getLayoutId(){
        return R.layout.example_fragment;
    }

    public void pushFragment(BaseFragment fragment, int id) {

        FragmentTransaction ft = getChildFragmentManager().beginTransaction();
//        fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        ft.replace(id, fragment);
        ft.commit();
    }

    public void pushFragmentStack(BaseFragment fragment, int id) {

        FragmentManager fragmentManager = getChildFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
//        fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
//        ft.setCustomAnimations(R.anim.enter, R.anim.exit_anim);
        ft.replace(id, fragment);
        ft.addToBackStack(null);
        ft.commitAllowingStateLoss();
    }
    public void pushFragmentChildStack(BaseFragment fragment, int id) {

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
//        fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
//        ft.setCustomAnimations(R.anim.enter, R.anim.exit_anim);
        ft.replace(id, fragment);
        ft.addToBackStack(null);
        ft.commitAllowingStateLoss();
    }
    public void onBackFragment() {
        FragmentManager fm = getFragmentManager();
        if (fm.getBackStackEntryCount() > 0) {
            fm.popBackStack();
        }
    }

    @Override
    public void navigator(Object action, Object... params) {

    }
}
