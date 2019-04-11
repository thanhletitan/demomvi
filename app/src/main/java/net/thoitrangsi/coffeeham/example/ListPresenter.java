package net.thoitrangsi.coffeeham.example;

import net.thoitrangsi.ptcore.baseview.PullAndLoadMoreLoader;
import net.thoitrangsi.ptcore.baseview.PullAndLoadMorePresenter;
import net.thoitrangsi.ptcore.baseview.PullAndLoadMoreView;
import net.thoitrangsi.ptcore.baseview.PullAndLoadMoreViewState;

/**
 * Created by thanh.le on 4/11/2019.
 */
public class ListPresenter extends PullAndLoadMorePresenter<PullAndLoadMoreView> {

    public ListPresenter(PullAndLoadMoreLoader loader) {
        super(loader);
    }
}
