package net.thoitrangsi.ptcore;

import android.os.Bundle;
import android.view.View;

import com.hannesdorfmann.mosby3.mvi.MviActivity;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import dagger.android.AndroidInjection;


/**
 * Created by thanh.le on 4/1/2019.
 */
public abstract class BaseActivity<V extends BaseView, P extends BasePresenter<V, ?>> extends MviActivity<V,P> implements NavigatorView{

    protected int setLayoutId(){
        return R.layout.activity_main;
    }

    protected abstract HeaderView setHeader();
    public void onBackFragment() {
        FragmentManager fm = getSupportFragmentManager();
        if (fm.getBackStackEntryCount() > 0) {
            fm.popBackStack();
        }
    }
    private void addHeader(){
        HeaderView headerView = findViewById(R.id.header);
        if(setHeader()!=null){
            headerView.removeAllViews();
            headerView.addView(setHeader());
            headerView.setVisibility(View.VISIBLE);
        }else {
            headerView.setVisibility(View.GONE);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayoutId());
        AndroidInjection.inject(this);
        addHeader();
        initView();

    }
    protected abstract void initView();
    /**
     * @param fragment         the fragment is replace into  R.id.fl_tab_content of root fragment
     * @param tag
     * @param isAddToBackStack
     */
    public void transferTabFragment(Fragment fragment, String tag, boolean isAddToBackStack, int id) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
//        ft.setCustomAnimations(R.anim.activity_open_enter, R.anim.activity_open_exit,
//                R.anim.activity_close_enter, R.anim.activity_close_exit);
        ft.replace(id, fragment);

        if (isAddToBackStack) ft.addToBackStack(tag);
        ft.commit();
    }

    public void transferTabFragmentNoStack(Fragment fragment, String tag, boolean isAddToBackStack, int id) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
//        ft.setCustomAnimations(R.anim.activity_open_enter, R.anim.activity_open_exit,
//                R.anim.activity_close_enter, R.anim.activity_close_exit);
        ft.replace(id, fragment);

        if (isAddToBackStack) ft.addToBackStack(tag);
        ft.commit();
    }
    @Override
    public void navigator(Object action, Object... params) {

    }
}
