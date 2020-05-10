package com.tenuchon.weatherapp.model.DTO;

import com.google.gson.annotations.SerializedName;

public class Weather {

    @SerializedName("id")
    private int id;

    @SerializedName("description")
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String main) {
        this.description = main;
    }
}
