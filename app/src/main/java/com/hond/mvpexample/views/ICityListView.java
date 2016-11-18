package com.hond.mvpexample.views;

import com.hond.mvpexample.beans.City;

import java.util.List;

/**
 * Created by hond on 11/18/2016.
 */

public interface ICityListView {
    void displayCities(List<City> cityList);

    void showProgress();

    void hideProgress();
}
