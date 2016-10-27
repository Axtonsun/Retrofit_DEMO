package com.example.axtonsun.retrofit_demo;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by AxtonSun on 2016/10/20.
 */

public interface PhoneService {
    @GET("apistore/mobilenumber/mobilenumber")
    Call<PhoneResult> getResult(@Header("apikey") String apikey, @Query("phone") String phone);
}
//直接请求型
//@GET("result/{id}")
//Call<PhoneResult> getResult(@Path("id") String id);

//带参数型
//@GET("/otn/lcxxcx/query")
//Call<Result> query(@Query("purpose_codes") String codes, @Query("queryDate") String date,
//@Query("from_station") String from, @Query("to_station") String to)

//带Header型
//@POST("/info")
//Call<Object> updateInfo(@Header("device") String device, @Header("version") int version,
//@Field("id") String id);

//@GET("/users/list")
//@GET("/users/list?sort=desc")
/**
 * Path
 */
//@GET("/group/{id}/users") //注意 字符串id
//List<User> groupList(@Path("id") int groupId); //注意 Path注解的参数要和前面的字符串一样 id

/**
 * 查询参数
 * Query
 */
//    @GET("/group/{id}/users")
//    List<User> groupList(@Path("id") int groupId, @Query("sort") String sort);
/**
 * 针对POST 的body
 */
//@Body 可以声明一个对象作为请求体发送到服务器

//@FormUrlEncoded 注解来发送表单数据
//@Field 注解和参数来指定每个表单项的Key，value为参数的值

//@Multipart 注解来发送multipart数据
//@Part 注解定义要发送的每个文件