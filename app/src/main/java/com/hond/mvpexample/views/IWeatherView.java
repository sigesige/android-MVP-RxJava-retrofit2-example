package com.hond.mvpexample.views;

import com.hond.mvpexample.beans.Weather;

/**
 * Created by hond on 11/18/2016.
 */

public interface IWeatherView {
    void showProgress();

    void hideProgress();

    void displayWeather(Weather weather);

    String getCityId();

}
