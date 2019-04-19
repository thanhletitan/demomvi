package net.thoitrangsi.ptcore;

import com.yheriatovych.reductor.Action;
import com.yheriatovych.reductor.Store;

import org.reactivestreams.Subscription;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import timber.log.Timber;


/**
 * Created by thanh.le on 4/11/2019.
 */
public class TransformState<VS> {
    Disposable subscription;

    public TransformState() {

    }

    public Observable<VS> dispatch(Observable<Action> allIntents, Store<VS> store) {
        PublishSubject<VS> statePublishSubject = PublishSubject.create();
        store.subscribe(state -> {
            statePublishSubject.onNext(state);
        });
        subscription = allIntents.subscribe(action -> {
            Timber.e("action:" + action);
            store.dispatch(action);
        });

        return statePublishSubject;
    }

    public void dispose() {
        if (subscription != null)
            subscription.dispose();
    }
}
