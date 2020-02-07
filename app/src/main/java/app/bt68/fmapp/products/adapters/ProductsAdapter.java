package app.bt68.fmapp.products.adapters;

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
import app.bt68.fmapp.databinding.ProductItemBinding;
import app.bt68.fmapp.home.itemViewModels.HomeItemViewModels;
import app.bt68.fmapp.home.models.Categories;
import app.bt68.fmapp.home.models.ProductsItem;
import app.bt68.fmapp.products.itemViewModels.ProductItemViewModels;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ViewHolder> {
    public List<ProductsItem> productsItems;
    Context context;

    public ProductsAdapter() {
        productsItems = new ArrayList<>();
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_item,
                parent, false);
        context = parent.getContext();
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ProductsItem dataModel = productsItems.get(position);
        ProductItemViewModels homeItemViewModels = new ProductItemViewModels(dataModel);
        homeItemViewModels.getItemsOperationsLiveListener().observe(((LifecycleOwner) context), new Observer<ProductsItem>() {
            @Override
            public void onChanged(ProductsItem productsItems) {
                MovementManager.startActivityWithBundle(context, Codes.PRODUCTS_DETAILS, productsItems.getName());
            }
        });
        homeItemViewModels.getClicksMutableLiveData().observe(((LifecycleOwner) context), new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                if (dataModel.isClicked()) {
                    dataModel.setClicked(false);
                    holder.itemBinding.plusIcon.setVisibility(View.VISIBLE);
                    holder.itemBinding.checkIcon.setVisibility(View.GONE);
                } else {
                    dataModel.setClicked(true);
                    holder.itemBinding.plusIcon.setVisibility(View.GONE);
                    holder.itemBinding.checkIcon.setVisibility(View.VISIBLE);
                }
            }
        });
        holder.setViewModel(homeItemViewModels);
    }


    @Override
    public int getItemCount() {
        return this.productsItems.size();
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

    public void updateData(@Nullable List<ProductsItem> data) {
        this.productsItems.clear();
        this.productsItems.addAll(data);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ProductItemBinding itemBinding;

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

        void setViewModel(ProductItemViewModels itemViewModels) {
            if (itemBinding != null) {
                itemBinding.setProductItemViewModels(itemViewModels);
            }
        }
    }
}
