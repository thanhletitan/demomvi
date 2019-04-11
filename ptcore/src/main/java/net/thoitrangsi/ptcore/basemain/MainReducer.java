package net.thoitrangsi.ptcore.basemain;

import com.yheriatovych.reductor.Action;
import com.yheriatovych.reductor.Reducer;
import com.yheriatovych.reductor.annotations.ActionCreator;
import com.yheriatovych.reductor.annotations.AutoReducer;

import net.thoitrangsi.ptcore.BaseState;


/**
 * Created by thanh.le on 4/3/2019.
 */
@AutoReducer
public abstract class MainReducer implements Reducer<BaseState> {

    @AutoReducer.InitialState
    BaseState initialState() {
        return new BaseState();
    }

    @AutoReducer.Action(value = MainActions.ADD, from = MainActions.class)
    BaseState add(BaseState state, int value) {
        return new BaseState();
    }
    static MainReducer create() {
        //Note: ItemsReducerImpl is generated class
        return new MainReducerImpl();
    }
}
@ActionCreator
interface MainActions {
    String ADD = "ADD";

    @ActionCreator.Action(ADD)
    Action add(int value);
}
