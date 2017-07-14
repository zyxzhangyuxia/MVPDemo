package com.zyx.demo_mvp.model;


import com.zyx.demo_mvp.mode.MovieEntrty;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;
import rx.Observer;

/**
 * Created by vectoria on 2017/7/13.
 * https://api.douban.com/v2/movie/top250?start=0&count=10
 */

public interface IMovieService {

    @GET("top250")
    Observable<MovieEntrty> getMovie(@Query("count") int count, @Query("start") int start);
}
