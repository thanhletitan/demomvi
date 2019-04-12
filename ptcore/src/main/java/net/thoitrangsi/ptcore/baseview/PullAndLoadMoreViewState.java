package net.thoitrangsi.ptcore.baseview;

import net.thoitrangsi.ptcore.BaseState;
import net.thoitrangsi.ptcore.basedata.ListData;
import net.thoitrangsi.ptcore.basedata.ObjectData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by thanh.le on 4/9/2019.
 */
public class PullAndLoadMoreViewState extends BaseState {
    private final boolean loadingFirstPage;
    private final Throwable error;
    private final ListData data;
    private final boolean loadingNextPage;
    private final boolean loadingPullToRefresh;
    private PullAndLoadMoreViewState(ListData data, boolean loadingFirstPage, Throwable error,
                                     boolean loadingNextPage, boolean loadingPullToRefresh) {
        this.data = data;
        this.loadingNextPage = loadingNextPage;
        this.error = error;
        this.loadingPullToRefresh = loadingPullToRefresh;
        this.loadingFirstPage = loadingFirstPage;
    }

    public ListData getData() {
        return data;
    }

    public boolean isLoadingNextPage() {
        return loadingNextPage;
    }

    public Throwable getError() {
        return error;
    }

    public boolean isLoadingPullToRefresh() {
        return loadingPullToRefresh;
    }


    public boolean isLoadingFirstPage() {
        return loadingFirstPage;
    }


    public Builder builder() {
        return new Builder(this);
    }

    @Override public String toString() {
        return "HomeViewState{"
                + "\nloadingFirstPage="
                + loadingFirstPage
                + ",\n error="
                + error
                + ",\n data="
                + ((data !=null && data.data != null) ? ""+data.data.size() : data)
                + ",\n loadingNextPage="
                + loadingNextPage
                + ",\n loadingPullToRefresh="
                + loadingPullToRefresh
                + "\n}";
    }
    public static final class Builder {
        private boolean loadingFirstPage;
        private Throwable error;
        private ListData data;
        private boolean loadingNextPage;
        private boolean loadingPullToRefresh;

        public Builder() {
            if(data!=null && data.data!=null)
            data.data = Collections.emptyList();
        }

        public Builder(PullAndLoadMoreViewState toCopyFrom) {
            if(data!=null && data.data!=null) {
                this.data.data = new ArrayList<>(toCopyFrom.getData().data.size());
                this.data.data.addAll(toCopyFrom.getData().data);
            }else {
                this.data = toCopyFrom.data;
            }
            this.loadingFirstPage = toCopyFrom.isLoadingFirstPage();
            this.loadingNextPage = toCopyFrom.isLoadingNextPage();
            this.loadingNextPage = toCopyFrom.isLoadingNextPage();
            this.error = toCopyFrom.getError();
        }

        public Builder firstPageLoading(boolean loadingFirstPage) {
            this.loadingFirstPage = loadingFirstPage;
            return this;
        }

        public Builder setError(Throwable error) {
            this.error = error;
            return this;
        }

        public Builder data(ListData data) {
            this.data = data;
            return this;
        }

        public Builder nextPageLoading(boolean loadingNextPage) {
            this.loadingNextPage = loadingNextPage;
            return this;
        }



        public Builder pullToRefreshLoading(boolean loading) {
            this.loadingPullToRefresh = loading;
            return this;
        }



        public PullAndLoadMoreViewState build() {
            return new PullAndLoadMoreViewState(data, loadingFirstPage, error, loadingNextPage,
                     loadingPullToRefresh);
        }
    }
}
