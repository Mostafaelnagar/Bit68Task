package app.bt68.fmapp.home.viewModels;


import android.view.View;

import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import app.bt68.fmapp.base.BaseViewModel;

import app.bt68.fmapp.base.MyApplication;
import app.bt68.fmapp.home.adapter.CategoriesAdapter;
import app.bt68.fmapp.home.models.Categories;
import app.bt68.fmapp.base.services.ServiceGenerator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomeViewModels extends BaseViewModel {
    CategoriesAdapter categoriesAdapter;

    public HomeViewModels() {
    }

    public void getHomeData() {
        accessLoadingBar(View.VISIBLE);
        ServiceGenerator.getRequestApi().getHomeData().enqueue(new Callback<List<Categories>>() {
            @Override
            public void onResponse(Call<List<Categories>> call, Response<List<Categories>> response) {
                accessLoadingBar(View.GONE);
                getCategoriesAdapter().updateData(response.body());
             }

            @Override
            public void onFailure(Call<List<Categories>> call, Throwable t) {
                accessLoadingBar(View.GONE);
             }
        });
    }

    @BindingAdapter({"app:categoriesAdapter"})
    public static void getCatBinding(RecyclerView recyclerView, CategoriesAdapter categoriesAdapter) {
        recyclerView.setLayoutManager(new GridLayoutManager(MyApplication.getInstance(), 2));
        recyclerView.setAdapter(categoriesAdapter);

    }

    @Bindable
    public CategoriesAdapter getCategoriesAdapter() {
        return this.categoriesAdapter == null ? this.categoriesAdapter = new CategoriesAdapter() : this.categoriesAdapter;
    }


}
