package net.thoitrangsi.ptcore;

import com.hannesdorfmann.mosby3.mvi.MviActivity;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


/**
 * Created by thanh.le on 4/1/2019.
 */
public abstract class BaseActivity<V extends BaseView, P extends BasePresenter<V, ?>> extends MviActivity<V,P> {

    public void onBackFragment() {
        FragmentManager fm = getSupportFragmentManager();
        if (fm.getBackStackEntryCount() > 0) {
            fm.popBackStack();
        }
    }
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
}
