package com.tenuchon.weatherapp.model.DTO;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CurrentWeather {
    @SerializedName("main")
    private Main main;

    @SerializedName("wind")
    private Wind wind;

    @SerializedName("clouds")
    private Clouds clouds;

    @SerializedName("weather")
    private List<Weather> weather;

    @SerializedName("name")
    private String cityName;

    @SerializedName("dt")
    private int time;

    @SerializedName("visibility")
    private int visibility;

    @SerializedName("timezone")
    private int timezone;

    @SerializedName("id")
    private int id;

    public int getTimezone() {
        return timezone;
    }

    public void setTimezone(int timezone) {
        this.timezone = timezone;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public String getWeather() {
        return weather.get(0).getDescription();
    }

    public int getWeatherId() {
        return weather.get(0).getId();
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getVisibility() {
        return visibility;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }

}
