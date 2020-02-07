package app.bt68.fmapp.products;


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;

import com.google.gson.Gson;

import app.bt68.fmapp.R;
import app.bt68.fmapp.base.BaseFragment;
import app.bt68.fmapp.base.constantsutils.Codes;
import app.bt68.fmapp.base.constantsutils.Params;
import app.bt68.fmapp.databinding.FragmentProductsBinding;
import app.bt68.fmapp.home.models.Categories;
import app.bt68.fmapp.products.viewModels.ProductsViewModels;


public class ProductsFragment extends BaseFragment {
    FragmentProductsBinding productsBinding;
    ProductsViewModels productsViewModels;
    String passingObject;
    Bundle bundle;

    public ProductsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        productsBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_products, container, false);
        bundle = this.getArguments();
        if (bundle != null) {
            passingObject = bundle.getString(Params.BUNDLE);
            productsViewModels = new ProductsViewModels();
            productsBinding.setProductsViewModels(productsViewModels);
            productsViewModels.setCategories(new Gson().fromJson(passingObject, Categories.class));
            productsViewModels.getProductsAdapter().updateData(productsViewModels.getCategories().getProducts());
        }
        liveDataListeners();
        return productsBinding.getRoot();
    }

    private void liveDataListeners() {
        productsViewModels.getClicksMutableLiveData().observe(this, result -> {
            if (result == Codes.BACK) {
                ((Activity) getActivity()).finish();
            }
        });
    }
}
