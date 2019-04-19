package net.thoitrangsi.ptcore.baseview;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.thoitrangsi.ptcore.R;
import net.thoitrangsi.ptcore.databinding.ItemLoadingBottomBinding;

import java.util.ArrayList;
import java.util.List;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import timber.log.Timber;

/**
 * Created by thanh.le on 4/11/2019.
 */
public abstract class PullAndLoadMoreAdapter<T, HD extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<HD> {

    protected static final int TYPE_HEADER = 2;
    protected static final int TYPE_ITEM = 1;
    protected static final int TYPE_FOOTER = 3;
    protected List<T> list = new ArrayList<>();
    protected boolean loading = false;
    public void updateList(List<T> newList) {
        this.list.clear();
        this.list.addAll(newList);
        notifyDataSetChanged();
    }
    public void addItems(List<T> newList){
        this.list.addAll(newList);
        notifyDataSetChanged();
    }
    public void addItem(T item){
        this.list.add(item);
        notifyDataSetChanged();
    }
    public void refreshAdapter(List<T> newList) {
        this.list.clear();
        this.list.addAll(newList);
        notifyDataSetChanged();
    }
    public void delete(T item) {
        this.list.remove(item);
        notifyDataSetChanged();
    }
    public void delete(List<T> itemList) {
        this.list.removeAll(itemList);
        notifyDataSetChanged();
    }
    public void clear() {
        this.list.clear();
        notifyDataSetChanged();
    }
    public void setLoading(boolean loading){
        this.loading = loading;
    }
    @Override
    public int getItemCount() {
        return list.size()+1;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == list.size())
            return TYPE_FOOTER;
        return TYPE_ITEM;
    }
}