package net.thoitrangsi.ptcore.basemain;

import android.os.Bundle;
import android.view.MenuItem;


import com.google.android.material.bottomnavigation.BottomNavigationView;

import net.thoitrangsi.ptcore.BaseActivity;
import net.thoitrangsi.ptcore.BaseFragment;
import net.thoitrangsi.ptcore.BasePresenter;
import net.thoitrangsi.ptcore.BaseView;

import net.thoitrangsi.ptcore.NavigatorView;
import net.thoitrangsi.ptcore.R;
import net.thoitrangsi.ptcore.ViewPagerAdapter;

import java.util.List;
import java.util.concurrent.TimeUnit;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import dagger.android.AndroidInjection;
import io.reactivex.Observable;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public abstract class BaseMainActivity<V extends BaseView, P extends BasePresenter<V, ?>> extends BaseActivity<V,P> implements NavigatorView {


    private ViewPager mViewPager;
    private ViewPagerAdapter adapter;
    private BottomNavigationView navigation;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        int id = 0;
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            int i = item.getItemId();
            if (i == R.id.navigation_home) {
                id = 0;

            } else if (i == R.id.navigation_dashboard) {
                id = 1;

            } else if (i == R.id.navigation_notifications) {
                id = 2;
            }
            mViewPager.setCurrentItem(id);
            return true;
        }
    };
    private int getTabBottomId(int pos){
        int id = -1;
        switch (pos) {
            case 0:
                id = R.id.navigation_home;
                break;
            case 1:
                id = R.id.navigation_dashboard;
                break;
            case 2:
                id = R.id.navigation_notifications;
                break;
        }
        return id;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayoutId());
        AndroidInjection.inject(this);
        setupViewPager();
        initView();

    }
    protected int setLayoutId(){
        return R.layout.activity_main;
    }
    protected abstract List<BaseFragment> addListFragments();
    protected abstract void initView();
    private void setupViewPager(){
        navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        mViewPager = findViewById(R.id.viewpager);
        adapter = new ViewPagerAdapter(getSupportFragmentManager(),this);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {



            @Override
            public void onPageScrolled(int position, float positionOffset,
                                       int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                navigation.setSelectedItemId(getTabBottomId(position));
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        addFragmentToViewPager(addListFragments());

    }
    private void addFragmentToViewPager(List<BaseFragment> fragments){
        Observable.just(fragments)
                .observeOn(Schedulers.io())
                .delay(100, TimeUnit.MILLISECONDS)
                .map(fragment -> {
                    adapter.addFragment(fragment);
                    return true;
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(aBoolean -> {
                    mViewPager.setAdapter(adapter);
                    mViewPager.setOffscreenPageLimit(fragments.size());
                });
    }

    @Override
    public void onBackPressed() {

        Fragment currentFragment = adapter.getRegisteredFragment(mViewPager.getCurrentItem());

        if (currentFragment != null) {
            // lets see if the currentFragment or any of its childFragment can handle onBackPressed
            FragmentManager fm = currentFragment.getChildFragmentManager();
            if (fm.getBackStackEntryCount() > 0) {
                fm.popBackStack();
                return;
            }

        }
//        if (previousPosition != 0) {
//            previousPosition = 0;
//            mViewPager.setCurrentItem(previousPosition, false);
//            return;
//        }
        super.onBackPressed();
    }

    @Override
    public void navigator(Object action, Object... params) {

    }
}
