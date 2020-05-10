package com.tenuchon.weatherapp.ui;

import android.os.Bundle;

import com.tenuchon.weatherapp.utils.DataUtils;
import com.tenuchon.weatherapp.R;
import com.tenuchon.weatherapp.model.City;
import com.tenuchon.weatherapp.utils.Converter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.widget.ImageView;
import android.widget.TextView;

public class AboutActivity extends AppCompatActivity {
    private TextView temp, pressure, clouds, windSpeed, humidity, feelsLike, visibility, weatherName;
    private ImageView weatherIcon;
    private City city;
    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        temp = findViewById(R.id.temp);
        pressure = findViewById(R.id.pressure);
        clouds = findViewById(R.id.clouds);
        windSpeed = findViewById(R.id.west_speed);
        humidity = findViewById(R.id.humidity);
        feelsLike = findViewById(R.id.feels_like);
        visibility = findViewById(R.id.visibility);
        weatherName = findViewById(R.id.weather_name);
        weatherIcon = findViewById(R.id.weather_icon);

        initValues();
    }

    private void initValues() {
        Bundle arg = getIntent().getExtras();
        if (arg != null)
            city = (City) arg.getSerializable("item");

        if (city != null) {
            getSupportActionBar().setTitle(city.getName());
            temp.setText(Converter.convertTemperature(city.getTemp()));
            pressure.setText(Converter.convertPressure(city.getPressure()));
            clouds.setText(Converter.convertClouds(city.getClouds()));
            windSpeed.setText(Converter.convertWindSpeed(city.getWindSpeed()));
            humidity.setText(Converter.convertHumidity(city.getHumidity()));
            feelsLike.setText(Converter.convertTemperature(city.getFeelsLike()));
            visibility.setText(Converter.convertVisibility(city.getVisibility()));
            weatherName.setText(city.getWeather());
            DataUtils.setWeatherIcon(weatherIcon, city.getWeatherId());
        }
    }
}
