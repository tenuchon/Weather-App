package com.tenuchon.weatherapp.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.tenuchon.weatherapp.db.CityBaseHelper;
import com.tenuchon.weatherapp.db.CityCursorWrapper;
import com.tenuchon.weatherapp.model.City;

import java.util.ArrayList;
import java.util.List;

import static com.tenuchon.weatherapp.db.CitiesDBScheme.CitiesTable.*;

public class CityLab {
    private static CityLab cityLab;
    private Context context;
    private SQLiteDatabase database;

    public CityLab(Context context) {
        this.context = context;
        database = new CityBaseHelper(context).getWritableDatabase();
    }

    public static CityLab getInstance(Context context) {
        if (cityLab == null) cityLab = new CityLab(context);
        return cityLab;
    }

    public List<City> getAllCities() {
        List<City> cities = new ArrayList<>();
        try (CityCursorWrapper cursor = queryCities(null, null)) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                cities.add(cursor.getCity());
                cursor.moveToNext();
            }
        }
        return cities;
    }

    public City getCity(String name) {
        try (CityCursorWrapper cursor = queryCities(Cols.NAME + " = ?", new String[]{name})) {
            if (cursor.getCount() == 0) {
                return null;
            }
            cursor.moveToFirst();
            return cursor.getCity();
        }
    }

    public void addCity(City city) {
        ContentValues values = getContentValues(city);
        database.insert(NAME, null, values);
    }

    public void removeCity(City city) {
        database.delete(NAME, Cols.NAME + " = ?", new String[]{city.getName()});
    }

    public void updateCity(City city) {
        ContentValues values = getContentValues(city);
        database.update(NAME, values, Cols.NAME + "= ?", new String[]{city.getName()});
    }

    public boolean isInDatabase(City city) {
        return getCity(city.getName()) == null;
    }


    public CityCursorWrapper queryCities(String whereClause, String[] whereArgs) {
        Cursor cursor = database.query(NAME, null, whereClause, whereArgs,
                null, null, null);
        return new CityCursorWrapper(cursor);
    }

    private static ContentValues getContentValues(City city) {
        ContentValues values = new ContentValues();
        values.put(Cols.WEATHER_ID, city.getWeatherId());
        values.put(Cols.DATE, city.getTime());
        values.put(Cols.NAME, city.getName());
        values.put(Cols.TEMP, city.getTemp());
        values.put(Cols.MAX_TEMP, city.getMaxTemp());
        values.put(Cols.MIN_TEMP, city.getMinTemp());
        values.put(Cols.WEATHER, city.getWeather());
        values.put(Cols.PRESSURE, city.getPressure());
        values.put(Cols.HUMIDITY, city.getHumidity());
        values.put(Cols.FEELS_LIKE, city.getFeelsLike());
        values.put(Cols.WIND_SPEED, city.getWindSpeed());
        values.put(Cols.CLOUDS, city.getClouds());
        values.put(Cols.VISIBILITY, city.getVisibility());
        values.put(Cols.TIMEZONE, city.getTimezone());
        return values;
    }

}

