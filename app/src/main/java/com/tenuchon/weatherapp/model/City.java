package com.tenuchon.weatherapp.model;


import com.tenuchon.weatherapp.model.DTO.CurrentWeather;

import java.io.Serializable;
public class City implements Serializable {
    private int weatherId;
    private String name;
    private int time;
    private double temp;
    private double maxTemp;
    private double minTemp;
    private String weather;
    private double pressure;
    private int humidity;
    private double feelsLike;
    private double windSpeed;
    private int clouds;
    private int visibility;
    private int timezone;

    public City() {
    }

    public City(CurrentWeather currentWeather) {
        weatherId = currentWeather.getWeatherId();
        name = currentWeather.getCityName();
        time = currentWeather.getTime();
        temp = currentWeather.getMain().getTemp();
        maxTemp = currentWeather.getMain().getMaxTemp();
        minTemp = currentWeather.getMain().getMinTemp();
        weather = currentWeather.getWeather();
        pressure = currentWeather.getMain().getPressure();
        humidity = currentWeather.getMain().getHumidity();
        feelsLike = currentWeather.getMain().getFeelsLike();
        windSpeed = currentWeather.getWind().getSpeed();
        clouds = currentWeather.getClouds().getAll();
        visibility = currentWeather.getVisibility();
        timezone = currentWeather.getTimezone();
    }

    public int getWeatherId() {
        return weatherId;
    }

    public void setWeatherId(int weatherId) {
        this.weatherId = weatherId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(double maxTemp) {
        this.maxTemp = maxTemp;
    }

    public double getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(double minTemp) {
        this.minTemp = minTemp;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public double getFeelsLike() {
        return feelsLike;
    }

    public void setFeelsLike(double feelsLike) {
        this.feelsLike = feelsLike;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public int getClouds() {
        return clouds;
    }

    public void setClouds(int clouds) {
        this.clouds = clouds;
    }

    public int getVisibility() {
        return visibility;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }

    public int getTimezone() {
        return timezone;
    }

    public void setTimezone(int timezone) {
        this.timezone = timezone;
    }
}
