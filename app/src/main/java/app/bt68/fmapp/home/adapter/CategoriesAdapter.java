package app.bt68.fmapp.home.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import app.bt68.fmapp.R;
import app.bt68.fmapp.base.MovementManager;
import app.bt68.fmapp.base.constantsutils.Codes;
import app.bt68.fmapp.databinding.HomeItemBinding;
import app.bt68.fmapp.home.itemViewModels.HomeItemViewModels;
import app.bt68.fmapp.home.models.Categories;
import app.bt68.fmapp.home.models.MainResponse;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.ViewHolder> {
    public List<Categories> categoriesItems;
    Context context;

    public CategoriesAdapter() {
        categoriesItems = new ArrayList<>();
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_item,
                parent, false);
        context = parent.getContext();
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Categories dataModel = categoriesItems.get(position);
        HomeItemViewModels homeItemViewModels = new HomeItemViewModels(dataModel);
        homeItemViewModels.getItemsOperationsLiveListener().observe(((LifecycleOwner) context), new Observer<Categories>() {
            @Override
            public void onChanged(Categories categoriesItem) {
                 MovementManager.startActivityWithObject(context, Codes.PRODUCTS, categoriesItem);
            }
        });

        holder.setViewModel(homeItemViewModels);
    }


    @Override
    public int getItemCount() {
        return this.categoriesItems.size();
    }

    //
    @Override
    public void onViewAttachedToWindow(ViewHolder holder) {
        super.onViewAttachedToWindow(holder);
        holder.bind();
    }

    @Override
    public void onViewDetachedFromWindow(ViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        holder.unbind();
    }

    public void updateData(@Nullable List<Categories> data) {
        this.categoriesItems.clear();

        this.categoriesItems.addAll(data);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        HomeItemBinding itemBinding;

        ViewHolder(View itemView) {
            super(itemView);
            bind();
        }


        void bind() {
            if (itemBinding == null) {
                itemBinding = DataBindingUtil.bind(itemView);
            }
        }

        void unbind() {
            if (itemBinding != null) {
                itemBinding.unbind();
            }
        }

        void setViewModel(HomeItemViewModels itemViewModels) {
            if (itemBinding != null) {
                itemBinding.setHomeItemViewModels(itemViewModels);
            }
        }
    }
}
