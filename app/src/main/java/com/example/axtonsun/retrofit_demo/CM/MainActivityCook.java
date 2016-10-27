package com.example.axtonsun.retrofit_demo.CM;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.axtonsun.retrofit_demo.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by AxtonSun on 2016/10/27.
 */

public class MainActivityCook extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cook_activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.rv_json);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.tngou.net/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        MealService service = retrofit.create(MealService.class);
        Call<Tngou> call = service.getList("cook",0,1,20);
        call.enqueue(new Callback<Tngou>() {
            @Override
            public void onResponse(Call<Tngou> call, Response<Tngou> response) {
                if (response.isSuccessful()){
                    List<Cook> cooks = response.body().getList();
                    Log.e("AAAAA", "onResponse: "+ response.body().getList() );
                    recyclerView.setAdapter(new MyAdapter(MainActivityCook.this,cooks));
                }
            }

            @Override
            public void onFailure(Call<Tngou> call, Throwable t) {

            }
        });
    }
}
