package net.thoitrangsi.ptcore.baseview;

import android.os.Bundle;
import android.view.View;

import com.jakewharton.rxbinding3.recyclerview.RxRecyclerView;
import com.jakewharton.rxbinding3.swiperefreshlayout.RxSwipeRefreshLayout;

import net.thoitrangsi.ptcore.BaseFragment;
import net.thoitrangsi.ptcore.R;
import net.thoitrangsi.ptcore.databinding.ListFragmentBinding;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import timber.log.Timber;

/**
 * Created by thanh.le on 4/9/2019.
 */
abstract public class PullAndLoadMoreListFragment<V extends PullAndLoadMoreView,
        P extends PullAndLoadMorePresenter<V>,VB extends ListFragmentBinding,A extends PullAndLoadMoreAdapter>
        extends BaseFragment<V,P,VB> implements PullAndLoadMoreView{

    protected A adapter;
    protected PublishSubject<Boolean> loadMoreOberservable = PublishSubject.create();
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RxRecyclerView.scrollEvents(binding.recyclerView).subscribe(recyclerViewScrollEvent -> {
            if(binding.recyclerView.getLayoutManager() instanceof  LinearLayoutManager){
                if (((LinearLayoutManager)(binding.recyclerView.getLayoutManager()))
                        .findLastCompletelyVisibleItemPosition() == adapter.getItemCount() - 1) {
                    Timber.e("last item recyclerView");
                    loadMoreOberservable.onNext(true);

                }
            }});
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
        binding.refreshLayout.setRefreshing(viewState.isLoadingPullToRefresh());
        adapter.setLoading(viewState.isLoadingNextPage());
    }
    @Override
    public Observable<Boolean> loadFirstPageIntent() {
        return Observable.just(true);
    }

    @Override
    public Observable<Boolean> loadNextPageIntent() {
        return loadMoreOberservable;
    }

    @Override
    public Observable<Boolean> pullToRefreshIntent() {
        return RxSwipeRefreshLayout.refreshes(binding.refreshLayout).map( click -> true);
    }
}
