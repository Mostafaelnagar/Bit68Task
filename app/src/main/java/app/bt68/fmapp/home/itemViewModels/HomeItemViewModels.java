package app.bt68.fmapp.home.itemViewModels;

import android.widget.ImageView;

import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;
import androidx.lifecycle.MutableLiveData;

import app.bt68.fmapp.base.BaseViewModel;
import app.bt68.fmapp.base.ConnectionHelper;
import app.bt68.fmapp.home.models.Categories;


public class HomeItemViewModels extends BaseViewModel {
    private Categories homeData;
    private MutableLiveData<Categories> itemsOperationsLiveListener;

    public HomeItemViewModels(Categories homeData) {
        this.homeData = homeData;
        this.itemsOperationsLiveListener = new MutableLiveData<>();
    }


    public MutableLiveData<Categories> getItemsOperationsLiveListener() {
        return itemsOperationsLiveListener;
    }


    @Bindable
    public Categories getHomeData() {
        return homeData;
    }


    public void itemAction() {
        notifyChange();
        itemsOperationsLiveListener.setValue(homeData);
    }

    @BindingAdapter({"homeImage"})
    public static void loadImage(ImageView view, String countryImage) {
        ConnectionHelper.loadImage(view, countryImage);
    }

}
