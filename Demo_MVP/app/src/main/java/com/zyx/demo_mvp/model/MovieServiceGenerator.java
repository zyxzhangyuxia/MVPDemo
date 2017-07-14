package com.zyx.demo_mvp.model;



import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2017/7/13.
 * 封装创建Retorfit和Service部分的代码
 */

public class MovieServiceGenerator {
    public static final String BASE_URL = "https://api.douban.com/v2/movie/";
    private static OkHttpClient.Builder  httpClientBuilder = new OkHttpClient.Builder();
    private static Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create());

    public static <S> S createService(Class<S> serviceClass) {
        Retrofit retrofit = retrofitBuilder.client(httpClientBuilder.build()).build();
        return retrofit.create(serviceClass);
    }
}
