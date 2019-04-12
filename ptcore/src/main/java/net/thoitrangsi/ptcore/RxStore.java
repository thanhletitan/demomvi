package net.thoitrangsi.ptcore;

import com.yheriatovych.reductor.Action;
import com.yheriatovych.reductor.Store;

import io.reactivex.Observable;
import io.reactivex.ObservableTransformer;
import io.reactivex.subjects.PublishSubject;
import timber.log.Timber;

/**
 * Created by thanh.le on 4/3/2019.
 */
public class RxStore {

    public RxStore(NavigatorView navigatorView, Object action,Object...params){
        if(navigatorView!=null){
            navigatorView.navigator(action,params);
        }
    }

    public RxStore(){
    }
    public Action merge(Action action){
        return action;
    }

    public Action action(){
        return new Action("Navigator");
    }
    public Action cancel(){
        return new Action("Cancel");
    }
}
