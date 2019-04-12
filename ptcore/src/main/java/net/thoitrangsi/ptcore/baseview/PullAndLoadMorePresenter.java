package net.thoitrangsi.ptcore.baseview;


import com.yheriatovych.reductor.Action;
import com.yheriatovych.reductor.Actions;
import com.yheriatovych.reductor.Store;

import net.thoitrangsi.ptcore.BasePresenter;
import net.thoitrangsi.ptcore.BaseState;
import net.thoitrangsi.ptcore.NavigatorView;
import net.thoitrangsi.ptcore.RxStore;
import net.thoitrangsi.ptcore.basedata.ListData;
import net.thoitrangsi.ptcore.basedata.ObjectData;


import java.util.ArrayList;
import java.util.Arrays;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

/**
 * Created by thanh.le on 4/9/2019.
 */
abstract public class PullAndLoadMorePresenter<V extends PullAndLoadMoreView> extends BasePresenter<V, PullAndLoadMoreViewState> {

    private PullAndLoadMoreLoader loader;

    public PullAndLoadMorePresenter(PullAndLoadMoreLoader loader) {
        this.loader = loader;

    }

    @Override
    protected void bindIntents() {
        Store<PullAndLoadMoreViewState> store = Store.create(PullAndLoadMoreReducer.create());
        PullAndLoadMoreActions reducers = Actions.from(PullAndLoadMoreActions.class);
        Observable<Action> loadFirstPage = intent(V::loadFirstPageIntent).doOnNext(
                ignored -> Timber.d("intent: load first page"))
                .flatMap(ignored -> loader.loadFirstPage()
                        .map(items -> reducers.setData(items, false))
                        .startWith(reducers.firstPageLoading(true, null))
                        .onErrorReturn(e -> reducers.firstPageLoading(false, e))
                        .subscribeOn(Schedulers.io()))
                .observeOn(AndroidSchedulers.mainThread());

        Observable<Action> nextPage =
                intent(V::loadNextPageIntent).doOnNext(ignored -> Timber.d("intent: load next page"))
                        .flatMap(ignored -> loader.loadNextPage()
                                .map(items -> reducers.setData(items, true))
                                .startWith(reducers.nextPageLoading(true, null))
                                .onErrorReturn(e -> reducers.nextPageLoading(false, e))
                                .subscribeOn(Schedulers.io()))
                        .observeOn(AndroidSchedulers.mainThread());
//
        Observable<Action> pullToRefresh = intent(V::pullToRefreshIntent).doOnNext(
                ignored -> Timber.d("intent: pull to refresh"))
                .flatMap(ignored -> loader.loadNewestPage()
                        .subscribeOn(Schedulers.io())
                        .map(items -> reducers.setData(items, false))
                        .startWith(reducers.pullToRefreshLoading(true, null))
                        .onErrorReturn(e -> reducers.pullToRefreshLoading(false, e)))
                .observeOn(AndroidSchedulers.mainThread());

        Observable<PullAndLoadMoreViewState> stateObservable =
                transformState.dispatch(otherAction() != null ?
                        Observable.merge(Arrays.asList(loadFirstPage, pullToRefresh, nextPage, otherAction())) :
                        Observable.merge(Arrays.asList(loadFirstPage, pullToRefresh, nextPage)), store);

        subscribeViewState(stateObservable.distinctUntilChanged(), V::render);


    }

    public Observable<Action> otherAction() {
        return null;
    }
}
