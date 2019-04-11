package net.thoitrangsi.coffeeham.example;

import android.os.Bundle;
import android.view.View;

import net.thoitrangsi.coffeeham.adapter.ListAdapter;
import net.thoitrangsi.ptcore.BaseState;
import net.thoitrangsi.ptcore.baseview.PullAndLoadMoreListFragment;
import net.thoitrangsi.ptcore.baseview.PullAndLoadMoreLoader;
import net.thoitrangsi.ptcore.baseview.PullAndLoadMoreView;
import net.thoitrangsi.ptcore.databinding.ListFragmentBinding;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import io.reactivex.Observable;

/**
 * Created by thanh.le on 4/9/2019.
 */
public class ListFragment extends PullAndLoadMoreListFragment<PullAndLoadMoreView, ListPresenter, ListFragmentBinding,ListAdapter> {


    @NonNull
    @Override
    public ListPresenter createPresenter() {
        return new ListPresenter(new PullAndLoadMoreLoader());
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

    @Override
    public Observable<Boolean> loadFirstPageIntent() {
        return null;
    }

    @Override
    public Observable<Boolean> loadNextPageIntent() {
        return null;
    }

    @Override
    public Observable<Boolean> pullToRefreshIntent() {
        return null;
    }

    @Override
    public Observable<Boolean> click() {
        return null;
    }

    @Override
    public Observable<Boolean> click2() {
        return null;
    }

    @Override
    public void render(BaseState state) {

    }

    @Override
    public void initView() {
        adapter = new ListAdapter();
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerView.setAdapter(adapter);
    }
}
