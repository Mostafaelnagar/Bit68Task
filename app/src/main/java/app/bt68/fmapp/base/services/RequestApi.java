package app.bt68.fmapp.base.services;


import java.util.List;

import app.bt68.fmapp.home.models.Categories;

import retrofit2.Call;

import retrofit2.http.GET;


public interface RequestApi {
    @GET("categories")
    Call<List<Categories>> getHomeData();

}
