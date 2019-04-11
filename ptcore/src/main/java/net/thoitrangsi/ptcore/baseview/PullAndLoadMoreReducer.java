package net.thoitrangsi.ptcore.baseview;

import com.yheriatovych.reductor.Action;
import com.yheriatovych.reductor.Reducer;
import com.yheriatovych.reductor.annotations.ActionCreator;
import com.yheriatovych.reductor.annotations.AutoReducer;

import net.thoitrangsi.ptcore.basedata.ListData;
import net.thoitrangsi.ptcore.basedata.ObjectData;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by thanh.le on 4/3/2019.
 */
@AutoReducer
public abstract class PullAndLoadMoreReducer implements Reducer<PullAndLoadMoreViewState> {

    @AutoReducer.InitialState
    PullAndLoadMoreViewState initialState() {
        return new PullAndLoadMoreViewState.Builder().build();
    }


    @AutoReducer.Action(value = PullAndLoadMoreActions.FIRSTLOAD, from = PullAndLoadMoreActions.class)
    PullAndLoadMoreViewState firstPageLoading(PullAndLoadMoreViewState state, boolean firstPage, Throwable throwable) {
        return state.builder()
                .firstPageLoading(firstPage)
                .setError(throwable)
                .build();
    }
    @AutoReducer.Action(value = PullAndLoadMoreActions.DATA, from = PullAndLoadMoreActions.class)
    PullAndLoadMoreViewState setData(PullAndLoadMoreViewState state, ListData data,boolean add) {
        ListData currentData = new ListData();
        currentData.data = new ArrayList<>(add ? state.getData().data.size()
                + data.data.size() : data.data.size());
        if(add){
            currentData.data.addAll(state.getData().data);
        }
        currentData.data.addAll(data.data);
        return state.builder()
                .data(currentData)
                .firstPageLoading(false)
                .nextPageLoading(false)
                .pullToRefreshLoading(false)
                .build();
    }

    @AutoReducer.Action(value = PullAndLoadMoreActions.NEXTLOAD, from = PullAndLoadMoreActions.class)
    PullAndLoadMoreViewState nextPageLoading(PullAndLoadMoreViewState state, boolean nextPage,
                                             Throwable throwable) {
        return state.builder()
                .nextPageLoading(nextPage)
                .setError(throwable)
                .build();
    }

    @AutoReducer.Action(value = PullAndLoadMoreActions.PULLTOREFRESH, from = PullAndLoadMoreActions.class)
    PullAndLoadMoreViewState pullToRefreshLoading(PullAndLoadMoreViewState state, boolean nextPage,
                                                  Throwable throwable) {
        return state.builder()
                .pullToRefreshLoading(nextPage)
                .setError(throwable)
                .build();
    }

    static PullAndLoadMoreReducer create() {
        //Note: ItemsReducerImpl is generated class
        return new PullAndLoadMoreReducerImpl();
    }
}

@ActionCreator
interface PullAndLoadMoreActions {
    String FIRSTLOAD = "FIRSTLOAD";
    String NEXTLOAD = "NEXTLOAD";
    String PULLTOREFRESH = "PULLTOREFRESH";
    String DATA = "DATA";


    @ActionCreator.Action(DATA)
    Action setData(ListData data, boolean add);

    @ActionCreator.Action(FIRSTLOAD)
    Action firstPageLoading(boolean firstPage, Throwable throwable);

    @ActionCreator.Action(NEXTLOAD)
    Action nextPageLoading(boolean nextPage, Throwable throwable);

    @ActionCreator.Action(PULLTOREFRESH)
    Action pullToRefreshLoading(boolean nextPage, Throwable throwable);


}
