package com.tenuchon.weatherapp.utils;

import com.tenuchon.weatherapp.WeatherApi;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkService {
    private static NetworkService instance;
    private static final String URL = "https://api.openweathermap.org";
    private Retrofit retrofit;

    private NetworkService() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder client = new OkHttpClient.Builder()
                .addInterceptor(interceptor);
        retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client.build())
                .build();
    }

    public static NetworkService getInstance() {
        if (instance == null) {
            synchronized (NetworkService.class) {
                if (instance == null)
                    instance = new NetworkService();
            }
        }
        return instance;
    }

    public WeatherApi getWeatherApi() {
        return retrofit.create(WeatherApi.class);
    }


}
