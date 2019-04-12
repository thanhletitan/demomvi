package net.thoitrangsi.ptcore.baseview;

import net.thoitrangsi.ptcore.basedata.ListData;
import net.thoitrangsi.ptcore.basedata.ObjectData;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.subjects.PublishSubject;
import timber.log.Timber;

/**
 * Created by thanh.le on 4/11/2019.
 */
public class PullAndLoadMoreLoader {
    public PullAndLoadMoreLoader(){

    }
    public Observable<ListData> loadNewestPage() {
        Timber.e("loadNewestPage");
        return Observable.just(Arrays.asList("1","2","3","4","5","6","7"))
                .map(list -> {
                    ListData<String> listData = new ListData<>();
                    listData.data = list;
                    return (ListData)listData;
                }).delay(2, TimeUnit.SECONDS);
    }

    /**
     * Loads the first page
     */
    public Observable<ListData> loadFirstPage() {
        Timber.e("loadNewestPage");
        return Observable.just(Arrays.asList("1","2","3","4","5","1","2","3","4","5","6","7","1","2","3","4","5","6","7"))
                .map(list -> {
                    ListData<String> listData = new ListData<>();
                    listData.data = list;
                    return (ListData)listData;
                }).delay(2, TimeUnit.SECONDS);
    }

    /**
     * loads the next page (pagination)
     */
    public Observable<ListData> loadNextPage() {
        Timber.e("loadNextPage");
        return Observable.just(Arrays.asList("1","2","3","4","5","6"))
                .map(list -> {
                    ListData<String> listData = new ListData<>();
                    listData.data = list;
                    return (ListData)listData;
                }).delay(2, TimeUnit.SECONDS);
    }

}
