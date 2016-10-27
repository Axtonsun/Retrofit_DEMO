package com.example.axtonsun.retrofit_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


   private static final String BASE_URL = "http://apis.baidu.com/";


    private static final String API_KEY = "c0c0469b2c8ae6e5c74eefd9ea7374e3";

    public TextView resultview;
    public  EditText editText;
    public Button btn1,btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultview = (TextView) findViewById(R.id.result_view);
        editText = (EditText) findViewById(R.id.phone_view);
        btn1 = (Button) findViewById(R.id.query_view);
        btn2 = (Button) findViewById(R.id.weather);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.query_view:
                queryphone();
                break;
            case R.id.weather:
                query();
                break;
        }
    }

    private void query(){

        resultview.setText("");
        //1.创建Retrofit对象
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())//解析方法
                .baseUrl(BASE_URL)//主机地址
                .build();


        WeatherService service = retrofit.create(WeatherService.class);
        Call<WeatherResult> call = service.WeatherGet(API_KEY,"重庆");
        //3.发送请求
        call.enqueue(new Callback<WeatherResult>() {
            @Override
            public void onResponse(Call<WeatherResult> call, Response<WeatherResult> response) {
                if (response.isSuccessful()){
                    WeatherResult result = response.body();
                    if (result != null){
                        WeatherResult.RetDataBean now = result.getRetData();
                        resultview.append("城市：" + now.getCity());
                        resultview.append("日期：" + now.getDate());
                        resultview.append("海拔：" + now.getAltitude());
                        resultview.append("气温：" + now.getTemp());
                        resultview.append("最高气温：" + now.getL_tmp());
                        resultview.append("最低气温：" + now.getValue0h_tmp());
                        resultview.append("天气情况：" + now.getWeather());
                        resultview.append("风向：" + now.getWD());
                        resultview.append("风力：" + now.getWS());
                        resultview.append("日出时间：" + now.getSunrise());
                        resultview.append("日落时间：" + now.getSunset());
                    }
                }
            }

            @Override
            public void onFailure(Call<WeatherResult> call, Throwable t) {

            }
        });

//        call.cancel(); 移除请求
    }

    private void queryphone() {

        resultview.setText("");
        //1.创建Retrofit对象
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())//解析方法
                .baseUrl(BASE_URL)//主机地址
                .build();

        PhoneService service = retrofit.create(PhoneService.class);
        Call<PhoneResult> call = service.getResult(API_KEY, editText.getText().toString());

                call.enqueue(new Callback<PhoneResult>() {
            @Override
            public void onResponse(Call<PhoneResult> call, Response<PhoneResult> response) {
                //4.处理结果
                if (response.isSuccessful()){
                    PhoneResult result = response.body();
                    if (result != null){
                        PhoneResult.RetDataEntity entity = result.getRetData();
                        resultview.append("地址：" + entity.getCity());
                    }
                }
            }

            @Override
            public void onFailure(Call<PhoneResult> call, Throwable t) {

            }
        });
    }

}
