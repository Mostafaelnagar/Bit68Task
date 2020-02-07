package app.bt68.fmapp.products;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;

import app.bt68.fmapp.R;
import app.bt68.fmapp.base.BaseFragment;
import app.bt68.fmapp.base.constantsutils.Params;
import app.bt68.fmapp.databinding.FragmentProductDetailsBinding;
import app.bt68.fmapp.products.viewModels.ProductsViewModels;


public class Product_DetailsFragment extends BaseFragment {
    FragmentProductDetailsBinding detailsBinding;
    ProductsViewModels productsViewModels;
    Bundle bundle;

    public Product_DetailsFragment() {
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
        detailsBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_product_details, container, false);
        productsViewModels = new ProductsViewModels();
        detailsBinding.setProductViewModel(productsViewModels);
        bundle = this.getArguments();
        if (bundle != null) {
            detailsBinding.productName.setText(bundle.getString(Params.BUNDLE));
        }
        return detailsBinding.getRoot();
    }


}
