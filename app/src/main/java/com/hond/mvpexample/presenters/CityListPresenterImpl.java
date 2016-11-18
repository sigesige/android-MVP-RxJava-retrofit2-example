package com.hond.mvpexample.presenters;

import android.os.Handler;

import com.hond.mvpexample.beans.City;
import com.hond.mvpexample.models.CityModelImpl;
import com.hond.mvpexample.models.ICityModel;
import com.hond.mvpexample.views.ICityListView;

import java.util.List;

/**
 * Created by hond on 11/18/2016.
 */

public class CityListPresenterImpl implements ICityListPresenter {
    ICityListView mCityListView;
    ICityModel mCityModel;

    public CityListPresenterImpl(ICityListView iCityListView) {
        this.mCityListView = iCityListView;
        mCityModel = new CityModelImpl();
    }

    @Override
    public void loadCities() {
        if (mCityListView != null) {
            mCityListView.showProgress();
        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //用来模拟数据库或者服务器延迟过程
            }
        }, 1000);

        List<City> cityList = mCityModel.getCityIdList();
        if (mCityListView != null) {
            mCityListView.hideProgress();
        }
        mCityListView.displayCities(cityList);
    }

    @Override
    public void onDestroy() {
        mCityListView = null;
    }

}
