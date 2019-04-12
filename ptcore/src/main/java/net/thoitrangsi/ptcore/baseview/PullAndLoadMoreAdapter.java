package net.thoitrangsi.ptcore.baseview;


import java.util.ArrayList;
import java.util.List;
import androidx.recyclerview.widget.RecyclerView;
import timber.log.Timber;

/**
 * Created by thanh.le on 4/11/2019.
 */
public abstract class PullAndLoadMoreAdapter<T, HD extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<HD> {

    private List<T> list = new ArrayList<>();


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
    @Override
    public int getItemCount() {
        return list.size();
    }


}