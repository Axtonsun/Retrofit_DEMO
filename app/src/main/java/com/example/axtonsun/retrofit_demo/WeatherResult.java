package com.example.axtonsun.retrofit_demo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by AxtonSun on 2016/10/21.
 */

public class WeatherResult {

    /**
     * errNum : 0
     * errMsg : success
     * retData : {"city":"北京","date":"15-02-11","altitude":"33","weather":"晴","temp":"10","l_tmp":"-4","0h_tmp":"10","WD":"无持续风向","WS":"微风(<10m/h)","sunrise":"07:12","sunset":"17:44"}
     */

    private String errNum;
    private String errMsg;
    /**
     * city : 北京
     * date : 15-02-11
     * altitude : 33
     * weather : 晴
     * temp : 10
     * l_tmp : -4
     * 0h_tmp : 10
     * WD : 无持续风向
     * WS : 微风(<10m/h)
     * sunrise : 07:12
     * sunset : 17:44
     */

    private RetDataBean retData;

    public String getErrNum() {
        return errNum;
    }

    public void setErrNum(String errNum) {
        this.errNum = errNum;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public RetDataBean getRetData() {
        return retData;
    }

    public void setRetData(RetDataBean retData) {
        this.retData = retData;
    }

    public static class RetDataBean {
        private String city;
        private String date;
        private String altitude;
        private String weather;
        private String temp;
        private String l_tmp;
        @SerializedName("0h_tmp")
        private String value0h_tmp;
        private String WD;
        private String WS;
        private String sunrise;
        private String sunset;

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getAltitude() {
            return altitude;
        }

        public void setAltitude(String altitude) {
            this.altitude = altitude;
        }

        public String getWeather() {
            return weather;
        }

        public void setWeather(String weather) {
            this.weather = weather;
        }

        public String getTemp() {
            return temp;
        }

        public void setTemp(String temp) {
            this.temp = temp;
        }

        public String getL_tmp() {
            return l_tmp;
        }

        public void setL_tmp(String l_tmp) {
            this.l_tmp = l_tmp;
        }

        public String getValue0h_tmp() {
            return value0h_tmp;
        }

        public void setValue0h_tmp(String value0h_tmp) {
            this.value0h_tmp = value0h_tmp;
        }

        public String getWD() {
            return WD;
        }

        public void setWD(String WD) {
            this.WD = WD;
        }

        public String getWS() {
            return WS;
        }

        public void setWS(String WS) {
            this.WS = WS;
        }

        public String getSunrise() {
            return sunrise;
        }

        public void setSunrise(String sunrise) {
            this.sunrise = sunrise;
        }

        public String getSunset() {
            return sunset;
        }

        public void setSunset(String sunset) {
            this.sunset = sunset;
        }
    }
}

