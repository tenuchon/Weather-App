package com.tenuchon.weatherapp;

import com.tenuchon.weatherapp.model.DTO.CurrentWeather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherApi {

    @GET("/data/2.5/weather")
    Call<CurrentWeather> getCurrentWeather(@Query("q") String cityName,
                                           @Query("appid") String key,
                                           @Query("units") String units,
                                           @Query("lang") String lang);


}
