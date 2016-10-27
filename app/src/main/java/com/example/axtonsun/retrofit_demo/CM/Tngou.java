package com.example.axtonsun.retrofit_demo.CM;

import com.example.axtonsun.retrofit_demo.CM.Cook;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by AxtonSun on 2016/10/27.
 */

public class Tngou {
    //加上注解
    @SerializedName("status")
    private boolean status;
    @SerializedName("total")
    private int total;
    @SerializedName("tngou")
    private List<Cook> list;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<Cook> getList() {
        return list;
    }

    public void setList(List<Cook> list) {
        this.list = list;
    }
}
