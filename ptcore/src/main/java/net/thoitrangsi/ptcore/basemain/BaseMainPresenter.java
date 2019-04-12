package net.thoitrangsi.ptcore.basemain;


import com.yheriatovych.reductor.Action;
import com.yheriatovych.reductor.Actions;
import com.yheriatovych.reductor.Store;

import net.thoitrangsi.ptcore.BasePresenter;
import net.thoitrangsi.ptcore.BaseState;
import net.thoitrangsi.ptcore.BaseView;
import net.thoitrangsi.ptcore.NavigatorView;
import net.thoitrangsi.ptcore.RxStore;
import net.thoitrangsi.ptcore.basemain.MainActions;
import net.thoitrangsi.ptcore.basemain.MainReducer;

import io.reactivex.Observable;

/**
 * Created by thanh.le on 4/1/2019.
 */
public class BaseMainPresenter extends BasePresenter<BaseView, BaseState> {

    private NavigatorView navigator;
    public BaseMainPresenter(NavigatorView navigatorView){
        this.navigator = navigatorView;
    }
    @Override
    protected void bindIntents() {

        Store<BaseState> store = Store.create(MainReducer.create());
        MainActions reducers = Actions.from(MainActions.class);


        Observable<Action> actionClick = intent(BaseView::click)
                .map( click -> new RxStore(navigator,NavigatorView.NavigatorAction.GO_FRAGMENT,true)
                        .merge(reducers.add(1)));

        Observable<Action> action2Click = intent(BaseView::click2)
                .map( click -> new RxStore(navigator,NavigatorView.NavigatorAction.GO_MAIN,true)
                                .action());


        Observable<BaseState> stateObservable =
                transformState.dispatch(Observable.merge(actionClick,action2Click),store);

       subscribeViewState(stateObservable.distinctUntilChanged(), BaseView::render) ;
    }

}

