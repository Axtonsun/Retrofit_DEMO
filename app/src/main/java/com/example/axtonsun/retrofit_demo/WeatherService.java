package com.example.axtonsun.retrofit_demo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by AxtonSun on 2016/10/21.
 */
//weather?cityid=CN101121501
public interface WeatherService {


    @GET("apistore/weatherservice/cityname")
    Call<WeatherResult> WeatherGet(@Header("apikey") String apikey, @Query("cityname") String cityname);

//    @GET("x3/weather?cityid={cityid}&key={apikey}")
//    //Call<> WeatherGet(@Query("cityid") String cityid,);
//    Call<WeatherResult> WeatherGet(@Query("cityid") String id,@Query("apikey") String key);
}
