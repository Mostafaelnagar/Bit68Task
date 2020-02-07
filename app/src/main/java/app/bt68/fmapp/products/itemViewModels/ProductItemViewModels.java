package app.bt68.fmapp.products.itemViewModels;

import android.widget.ImageView;

import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;
import androidx.lifecycle.MutableLiveData;

import app.bt68.fmapp.base.BaseViewModel;
import app.bt68.fmapp.base.ConnectionHelper;
import app.bt68.fmapp.base.constantsutils.Codes;
import app.bt68.fmapp.home.models.Categories;
import app.bt68.fmapp.home.models.ProductsItem;


public class ProductItemViewModels extends BaseViewModel {
    private ProductsItem productsItem;
    private MutableLiveData<ProductsItem> itemsOperationsLiveListener;

    public ProductItemViewModels(ProductsItem productsItem) {
        this.productsItem = productsItem;
        this.itemsOperationsLiveListener = new MutableLiveData<>();
    }


    public MutableLiveData<ProductsItem> getItemsOperationsLiveListener() {
        return itemsOperationsLiveListener;
    }


    @Bindable
    public ProductsItem getProductsItem() {
        return productsItem;
    }


    public void itemAction() {
        notifyChange();
        itemsOperationsLiveListener.setValue(productsItem);
    }

    @BindingAdapter({"productImage"})
    public static void loadImage(ImageView view, String countryImage) {
        ConnectionHelper.loadImage(view, countryImage);
    }

    public void plusIconAction() {
        getClicksMutableLiveData().setValue(Codes.PLUS_CLICK);
    }
}
