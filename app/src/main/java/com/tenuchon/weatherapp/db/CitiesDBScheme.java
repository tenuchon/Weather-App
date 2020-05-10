package com.tenuchon.weatherapp.db;

public class CitiesDBScheme {
    public final static class CitiesTable {
        public static final String NAME = "cities";

        public final static class Cols {
            public static final String WEATHER_ID = "weather_id";
            public static final String DATE = "date";
            public static final String NAME = "name";
            public static final String TEMP = "temp";
            public static final String MAX_TEMP = "max_temp";
            public static final String MIN_TEMP = "min_temp";
            public static final String WEATHER = "weather";
            public static final String PRESSURE = "pressure";
            public static final String HUMIDITY = "humidity";
            public static final String FEELS_LIKE = "feels_like";
            public static final String WIND_SPEED = "wind_speed";
            public static final String CLOUDS = "clouds";
            public static final String VISIBILITY = "visibility";
            public static final String TIMEZONE = "timezone";
        }
    }
}
