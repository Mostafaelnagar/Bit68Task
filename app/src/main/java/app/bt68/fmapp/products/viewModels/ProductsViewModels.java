package app.bt68.fmapp.products.viewModels;


import android.widget.ImageView;

import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import app.bt68.fmapp.base.BaseViewModel;
import app.bt68.fmapp.base.ConnectionHelper;
import app.bt68.fmapp.base.constantsutils.Codes;
import app.bt68.fmapp.base.MyApplication;
import app.bt68.fmapp.home.models.Categories;
import app.bt68.fmapp.products.adapters.ProductsAdapter;


public class ProductsViewModels extends BaseViewModel {
    ProductsAdapter productsAdapter;
    Categories categories;

    public ProductsViewModels() {
        categories = new Categories();
     }

    public Categories getCategories() {
        return categories;
    }

    @Bindable
    public void setCategories(Categories categories) {
        notifyPropertyChanged(app.bt68.fmapp.BR.categories);
        this.categories = categories;
    }


    @BindingAdapter({"app:productsAdapter"})
    public static void getProductBinding(RecyclerView recyclerView, ProductsAdapter productsAdapter) {
        recyclerView.setLayoutManager(new GridLayoutManager(MyApplication.getInstance(), 2));
        recyclerView.setAdapter(productsAdapter);

    }

    @Bindable
    public ProductsAdapter getProductsAdapter() {
        return this.productsAdapter == null ? this.productsAdapter = new ProductsAdapter() : this.productsAdapter;
    }

    @BindingAdapter({"catImage"})
    public static void loadImage(ImageView view, String countryImage) {
        ConnectionHelper.loadImage(view, countryImage);
    }
    public void toBack(){
        getClicksMutableLiveData().setValue(Codes.BACK);
    }
}
