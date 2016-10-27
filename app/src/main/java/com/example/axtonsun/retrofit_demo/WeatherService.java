package com.example.axtonsun.retrofit_demo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by AxtonSun on 2016/10/21.
 */
//weather?cityid=CN101121501
public interface WeatherService {
    @GET("x3/weather?cityid={cityid}&key={apikey}")
    //Call<> WeatherGet(@Query("cityid") String cityid,);
    Call<WeatherResult> WeatherGet(@Query("cityid") String id,@Path("apikey") String key);
}
