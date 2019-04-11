
package net.thoitrangsi.ptcore;

import android.content.Context;
import android.util.SparseArray;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;


public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    Context mContext;

    SparseArray<BaseFragment> registeredFragments = new SparseArray<>();
    List<BaseFragment> fragments;
    public ViewPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        mContext = context;
        fragments = new ArrayList<>();
    }
    public void addFragment(List<BaseFragment> fragments){
        this.fragments.addAll(fragments);
    }
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        BaseFragment fragment = (BaseFragment) super.instantiateItem(container, position);
        registeredFragments.put(position, fragment);
        return fragment;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        registeredFragments.remove(position);
        super.destroyItem(container, position, object);
    }

    public Fragment getRegisteredFragment(int position) {
        return registeredFragments.get(position);
    }
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }


}
