package com.tenuchon.weatherapp.model.DTO;

import com.google.gson.annotations.SerializedName;

public class Main {
    @SerializedName("temp")
    private double temp;

    @SerializedName("pressure")
    private double pressure;

    @SerializedName("temp_max")
    private double maxTemp;

    @SerializedName("temp_min")
    private double minTemp;

    @SerializedName("feels_like")
    private double feelsLike;

    @SerializedName("humidity")
    private int humidity;

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
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

    public double getFeelsLike() {
        return feelsLike;
    }

    public void setFeelsLike(double feelsLike) {
        this.feelsLike = feelsLike;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }
}
