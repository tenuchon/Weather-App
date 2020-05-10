package com.tenuchon.weatherapp.db;

import android.database.Cursor;
import android.database.CursorWrapper;

import static com.tenuchon.weatherapp.db.CitiesDBScheme.*;


import com.tenuchon.weatherapp.model.City;

public class CityCursorWrapper extends CursorWrapper {

    public CityCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public City getCity() {
        int weatherId = getInt(getColumnIndex(CitiesTable.Cols.WEATHER_ID));
        int date = getInt(getColumnIndex(CitiesTable.Cols.DATE));
        String name = getString(getColumnIndex(CitiesTable.Cols.NAME));
        double temp = getDouble(getColumnIndex(CitiesTable.Cols.TEMP));
        double maxTemp = getDouble(getColumnIndex(CitiesTable.Cols.MAX_TEMP));
        double minTemp = getDouble(getColumnIndex(CitiesTable.Cols.MIN_TEMP));
        String weather = getString(getColumnIndex(CitiesTable.Cols.WEATHER));
        double pressure = getDouble(getColumnIndex(CitiesTable.Cols.PRESSURE));
        int humidity = getInt(getColumnIndex(CitiesTable.Cols.HUMIDITY));
        double feelsLike = getDouble(getColumnIndex(CitiesTable.Cols.FEELS_LIKE));
        double windSpeed = getDouble(getColumnIndex(CitiesTable.Cols.WIND_SPEED));
        int clouds = getInt(getColumnIndex(CitiesTable.Cols.CLOUDS));
        int visibility = getInt(getColumnIndex(CitiesTable.Cols.VISIBILITY));
        int timezone = getInt(getColumnIndex(CitiesTable.Cols.TIMEZONE));

        City city = new City();
        city.setWeatherId(weatherId);
        city.setTime(date);
        city.setName(name);
        city.setTemp(temp);
        city.setMaxTemp(maxTemp);
        city.setMinTemp(minTemp);
        city.setWeather(weather);
        city.setPressure(pressure);
        city.setHumidity(humidity);
        city.setFeelsLike(feelsLike);
        city.setWindSpeed(windSpeed);
        city.setClouds(clouds);
        city.setVisibility(visibility);
        city.setTimezone(timezone);

        return city;
    }
}
