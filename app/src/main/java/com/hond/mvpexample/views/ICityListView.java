package com.hond.mvpexample.views;

import com.hond.mvpexample.beans.City;

import java.util.List;

/**
 * Created by hond on 11/18/2016.
 */

public interface ICityListView {
    void addDataToAdapter(List<City> list);

    void showProgress();

    void hideProgress();
}
