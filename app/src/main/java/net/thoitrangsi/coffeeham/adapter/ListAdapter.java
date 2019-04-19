package net.thoitrangsi.coffeeham.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.thoitrangsi.coffeeham.R;
import net.thoitrangsi.coffeeham.databinding.ItemListBinding;
import net.thoitrangsi.ptcore.basedata.ObjectData;
import net.thoitrangsi.ptcore.baseview.PullAndLoadMoreAdapter;
import net.thoitrangsi.ptcore.databinding.ItemLoadingBottomBinding;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by thanh.le on 4/11/2019.
 */
public class ListAdapter extends PullAndLoadMoreAdapter<ObjectData<String>, ListAdapter.ItemHomeHolder> {


    @NonNull
    @Override
    public ItemHomeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == TYPE_ITEM) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
            ItemHomeHolder viewHolder = new ItemHomeHolder(view, viewType);
            return viewHolder;
        } else {
            if (viewType == TYPE_FOOTER) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_loading_bottom, parent, false);
                ItemHomeHolder viewHolder = new ItemHomeHolder(view, viewType);
                return viewHolder;
            }
        }
        throw new RuntimeException("There is no type that matches the type " + viewType + " + make sure your using types correctly");
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHomeHolder holder, int position) {
        if(getItemViewType(position) == TYPE_FOOTER){
            holder.itemLoadingBottomBinding.setLoading(loading);
        }else {
            holder.binding.setText("" + position);
            holder.binding.executePendingBindings();
        }

    }


    public class ItemHomeHolder extends RecyclerView.ViewHolder {
        ItemListBinding binding;
        ItemLoadingBottomBinding itemLoadingBottomBinding ;

        public ItemHomeHolder(View view, int type) {
            super(view);
            if (type == TYPE_ITEM)
                binding = DataBindingUtil.bind(view);
            if (type == TYPE_FOOTER)
                itemLoadingBottomBinding = DataBindingUtil.bind(view);
        }


    }
}
