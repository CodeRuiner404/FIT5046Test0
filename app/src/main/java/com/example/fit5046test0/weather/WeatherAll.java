package com.example.fit5046test0.weather;

import com.google.gson.annotations.SerializedName;

public class WeatherAll {
    @SerializedName("we")
    WeatherEntity we;

    public WeatherEntity getWe() {
        return we;
    }

    public void setWe(WeatherEntity we) {
        this.we = we;
    }
}
