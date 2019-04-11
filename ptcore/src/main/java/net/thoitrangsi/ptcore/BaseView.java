package net.thoitrangsi.ptcore;

import com.hannesdorfmann.mosby3.mvp.MvpView;

import io.reactivex.Observable;

/**
 * Created by thanh.le on 4/1/2019.
 */
public interface BaseView extends NavigatorView {


    Observable<Boolean> click();
    Observable<Boolean> click2();
    void render(BaseState state);
}
