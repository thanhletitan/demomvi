package net.thoitrangsi.coffeeham.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.thoitrangsi.coffeeham.R;
import net.thoitrangsi.coffeeham.databinding.ItemListBinding;
import net.thoitrangsi.ptcore.basedata.ObjectData;
import net.thoitrangsi.ptcore.baseview.PullAndLoadMoreAdapter;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by thanh.le on 4/11/2019.
 */
public class ListAdapter extends PullAndLoadMoreAdapter<ObjectData<String>,ListAdapter.ItemHomeHolder> {


    @NonNull
    @Override
    public ItemHomeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        ItemHomeHolder viewHolder = new ItemHomeHolder(view, viewType);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHomeHolder holder, int position) {
        holder.binding.setText(""+position);
    }

    public class ItemHomeHolder extends RecyclerView.ViewHolder{

        ItemListBinding binding;
        public ItemHomeHolder(View view, int type) {
            super(view);
            binding = DataBindingUtil.bind(view);
        }


    }
}
