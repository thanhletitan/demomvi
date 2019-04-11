package net.thoitrangsi.ptcore;

import com.hannesdorfmann.mosby3.mvp.MvpView;

/**
 * Created by thanh.le on 4/3/2019.
 */
public interface NavigatorView extends MvpView {
    void navigator(Object action,Object...params);
     enum NavigatorAction {
        GO_MAIN, GO_FRAGMENT
    }
}
