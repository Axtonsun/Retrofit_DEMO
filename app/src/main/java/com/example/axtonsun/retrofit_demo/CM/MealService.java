package com.example.axtonsun.retrofit_demo.CM;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by AxtonSun on 2016/10/27.
 */

public interface MealService {
    @GET("api/{category}/list")
    Call<Tngou> getList(@Path("category") String path, @Query("id") int id, @Query("page") int page, @Query("rows") int rows);
}
