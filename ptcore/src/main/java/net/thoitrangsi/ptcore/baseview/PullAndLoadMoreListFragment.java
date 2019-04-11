package net.thoitrangsi.ptcore.baseview;

import android.os.Bundle;
import android.view.View;

import net.thoitrangsi.ptcore.BaseFragment;
import net.thoitrangsi.ptcore.R;
import net.thoitrangsi.ptcore.databinding.ListFragmentBinding;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import timber.log.Timber;

/**
 * Created by thanh.le on 4/9/2019.
 */
abstract public class PullAndLoadMoreListFragment<V extends PullAndLoadMoreView,
        P extends PullAndLoadMorePresenter<V>,VB extends ListFragmentBinding,A extends PullAndLoadMoreAdapter>
        extends BaseFragment<V,P,VB> implements PullAndLoadMoreView{

    protected A adapter;
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public int getLayoutId() {
        return R.layout.list_fragment;
    }

    @Override
    public void render(PullAndLoadMoreViewState viewState) {
        Timber.e("state:"+viewState.toString());
        if(viewState.getData()!=null){
            adapter.refreshAdapter(viewState.getData().data);
        }

    }
}
