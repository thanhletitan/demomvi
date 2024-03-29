package net.thoitrangsi.ptcore;

import com.hannesdorfmann.mosby3.mvi.MviBasePresenter;

/**
 * Created by thanh.le on 4/1/2019.
 */
public abstract class BasePresenter<V extends BaseView, VS extends BaseState> extends MviBasePresenter<V, VS> {
    protected TransformState<VS> transformState;

    public BasePresenter() {
        transformState = new TransformState<>();
    }


    @Override
    public void destroy() {
        super.destroy();
        transformState.dispose();
    }
}
