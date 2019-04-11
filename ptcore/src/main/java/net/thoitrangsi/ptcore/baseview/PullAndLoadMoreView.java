package net.thoitrangsi.ptcore.baseview;

import net.thoitrangsi.ptcore.BaseView;

import io.reactivex.Observable;

/**
 * Created by thanh.le on 4/9/2019.
 */
public interface PullAndLoadMoreView extends BaseView {
    /**
     * The intent to load the first page
     *
     * @return The emitted item boolean can be ignored because it is always true
     */
    Observable<Boolean> loadFirstPageIntent();

    /**
     * The intent to load the next page
     *
     * @return The emitted item boolean can be ignored because it is always true
     */
    Observable<Boolean> loadNextPageIntent();

    /**
     * The intent to react on pull-to-refresh
     *
     * @return The emitted item boolean can be ignored because it is always true
     */
    Observable<Boolean> pullToRefreshIntent();

    /**
     * The intent to load more items from a given group
     *
     * @return Observable with the name of the group
     */
    /**
     * Renders the viewState
     */
    void render(PullAndLoadMoreViewState viewState);
}
