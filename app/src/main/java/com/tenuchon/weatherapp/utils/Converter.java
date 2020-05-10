package com.tenuchon.weatherapp.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class Converter {
    private static final String TIME = "E, dd MMM HH:mm";
    private static final String TEMPERATURE = "%.0f°";
    private static final String MAX_MIN = "%.0f°/%.0f°";
    private static final String PRESSURE = "%.0f гПа";
    private static final String CLOUDS = "%d%%";
    private static final String WIND_SPEED = "%.0f м/с";
    private static final String HUMIDITY = "%d%%";
    private static final String VISIBILITY = "%d м";


    public static String convertTime(int time, int timeZone) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(TIME, Locale.getDefault());
        TimeZone zone = TimeZone.getDefault();
        zone.setRawOffset(timeZone * 1000);
        dateFormat.setTimeZone(zone);
        Date date = new Date(time * 1000L);
        return dateFormat.format(date);
    }

    public static String convertTemperature(double temp) {
        return String.format(Locale.getDefault(), TEMPERATURE, temp);
    }

    public static String convertMaxAndMin(double max, double min) {
        return String.format(Locale.getDefault(), MAX_MIN, max, min);
    }

    public static String convertPressure(double pressure) {
        return String.format(Locale.getDefault(), PRESSURE, pressure);
    }

    public static String convertClouds(int clouds) {
        return String.format(Locale.getDefault(), CLOUDS, clouds);
    }

    public static String convertWindSpeed(double windSpeed) {
        return String.format(Locale.getDefault(), WIND_SPEED, windSpeed);
    }

    public static String convertHumidity(int humidity) {
        return String.format(Locale.getDefault(), HUMIDITY, humidity);
    }

    public static String convertVisibility(int visibility) {
        return String.format(Locale.getDefault(), VISIBILITY, visibility);
    }


}
