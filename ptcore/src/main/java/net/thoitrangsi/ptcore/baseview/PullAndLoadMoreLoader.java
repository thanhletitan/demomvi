package net.thoitrangsi.ptcore.baseview;

import net.thoitrangsi.ptcore.basedata.ListData;
import net.thoitrangsi.ptcore.basedata.ObjectData;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

/**
 * Created by thanh.le on 4/11/2019.
 */
public class PullAndLoadMoreLoader {
    public PullAndLoadMoreLoader(){

    }
    public Observable<ListData> loadNewestPage() {
        return PublishSubject.create();
    }

    /**
     * Loads the first page
     */
    public Observable<ListData> loadFirstPage() {
        return PublishSubject.create();
    }

    /**
     * loads the next page (pagination)
     */
    public Observable<ListData> loadNextPage() {
        return PublishSubject.create();
    }

}
