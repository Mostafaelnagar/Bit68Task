package app.bt68.fmapp.base.services;

import java.io.IOException;

import app.bt68.fmapp.base.URLS;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {

    public static RequestApi getRequestApi() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();


        httpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request().newBuilder().build();
                return chain.proceed(request);
            }
        });
        Retrofit retrofit = new Retrofit.Builder().addCallAdapterFactory(RxJava2CallAdapterFactory.create()).addConverterFactory(GsonConverterFactory.create()).baseUrl(URLS.DEFAULT_LINK).client(httpClient.build()).build();

        RequestApi requestApi = retrofit.create(RequestApi.class);
        return requestApi;
    }
}
