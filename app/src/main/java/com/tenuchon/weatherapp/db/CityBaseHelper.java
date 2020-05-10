package com.tenuchon.weatherapp.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import  static com.tenuchon.weatherapp.db.CitiesDBScheme.*;

public class CityBaseHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "citiesBase.db";

    public CityBaseHelper(Context context){
        super(context,DATABASE_NAME,null,VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + CitiesTable.NAME + "(" +
                "_id integer primary key autoincrement, " +
                CitiesTable.Cols.WEATHER_ID + ", " +
                CitiesTable.Cols.DATE + ", " +
                CitiesTable.Cols.NAME + ", " +
                CitiesTable.Cols.TEMP + ", " +
                CitiesTable.Cols.MAX_TEMP + ", " +
                CitiesTable.Cols.MIN_TEMP + ", " +
                CitiesTable.Cols.WEATHER + ", " +
                CitiesTable.Cols.PRESSURE + ", " +
                CitiesTable.Cols.HUMIDITY + ", " +
                CitiesTable.Cols.FEELS_LIKE + ", " +
                CitiesTable.Cols.WIND_SPEED + ", " +
                CitiesTable.Cols.CLOUDS + ", " +
                CitiesTable.Cols.VISIBILITY + ", " +
                CitiesTable.Cols.TIMEZONE + ")");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
