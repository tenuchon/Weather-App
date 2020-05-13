package com.tenuchon.weatherapp.utils;

import android.content.Context;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.squareup.picasso.Picasso;
import com.tenuchon.weatherapp.R;
import com.tenuchon.weatherapp.model.City;
import com.tenuchon.weatherapp.model.DTO.CurrentWeather;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class DataUtils {
    private static final String KEY = "770e015e38d5c4eadf68b1289999af33";
    private static final String DIMENSION = "metric";
    private static final String LANGUAGE = "ru";

    public static void loadCity(final String cityName, final CityAdapter adapter, final Context context, final SwipeRefreshLayout refreshLayout, final boolean isLast) {
        NetworkService.getInstance().getWeatherApi().getCurrentWeather(cityName, KEY, DIMENSION, LANGUAGE)
                .enqueue(new Callback<CurrentWeather>() {
                    @Override
                    public void onResponse(Call<CurrentWeather> call, Response<CurrentWeather> response) {
                        if (response.isSuccessful()) {
                            if (adapter != null) addCityOnDatabase(adapter, response);
                            else updateCityOnDatabase(context, response, refreshLayout, isLast);

                        } else
                            Toast.makeText(context, context.getString(R.string.try_again), Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<CurrentWeather> call, Throwable t) {
                        t.printStackTrace();
                        Toast.makeText(context, context.getString(R.string.error), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private static void addCityOnDatabase(CityAdapter adapter, Response<CurrentWeather> response) {
        Context context = adapter.getContext();
        CurrentWeather currentWeather = response.body();
        if (currentWeather != null) {
            City city = new City(currentWeather);
            if (CityLab.getInstance(context).isInDatabase(city)) {
                CityLab.getInstance(context).addCity(city);
                adapter.addCity(city);
                adapter.notifyDataSetChanged();
                Toast.makeText(context, context.getString(R.string.city_added, city.getName()), Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(context, context.getString(R.string.city_allredy), Toast.LENGTH_LONG).show();
            }
        }
    }


    private static void updateCityOnDatabase(Context context, Response<CurrentWeather> response, SwipeRefreshLayout refreshLayout, boolean isLast) {
        CurrentWeather currentWeather = response.body();
        if (currentWeather != null) {
            City copy = new City(currentWeather);
            CityLab.getInstance(context).updateCity(copy);
            //если последний элемент, убираем Progress Bar
            if (isLast) refreshLayout.setRefreshing(false);
        }
    }

    public static List<City> getCitiesList(Context context, SwipeRefreshLayout refreshLayout) {
        List<City> list = CityLab.getInstance(context).getAllCities();

        //Если список город не пуст, то обновляем дынные
        if (list.size() != 0) {
            //последний элемент
            boolean isLast = false;
            for (int i = 0; i < list.size(); i++) {
                if (i + 1 == list.size()) isLast = true;

                loadCity(list.get(i).getName(), null, context, refreshLayout, isLast);
            }
            list = CityLab.getInstance(context).getAllCities();
        }
        return list;
    }

    public static void setWeatherIcon(ImageView view, int weatherCode) {
        if (weatherCode / 100 == 2) {
            Picasso.get().load(R.drawable.icon_thunderstorm_day).into(view);
        } else if (weatherCode / 100 == 3 || weatherCode / 100 == 5) {
            Picasso.get().load(R.drawable.icon_shower_rain_day).into(view);
        } else if (weatherCode / 100 == 6) {
            Picasso.get().load(R.drawable.icon_snow_day).into(view);
        } else if (weatherCode / 100 == 7) {
            Picasso.get().load(R.drawable.icon_mist_day).into(view);
        } else if (weatherCode == 800) {
            Picasso.get().load(R.drawable.icon_clear_sky_day).into(view);
        } else if (weatherCode == 801 || weatherCode == 802) {
            Picasso.get().load(R.drawable.icon_few_clouds_day).into(view);
        } else if (weatherCode == 803 || weatherCode / 100 == 8) {
            Picasso.get().load(R.drawable.icon_broken_clouds_day).into(view);
        }
    }
}
