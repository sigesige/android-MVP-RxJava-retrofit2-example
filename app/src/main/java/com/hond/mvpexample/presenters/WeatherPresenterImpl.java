package com.hond.mvpexample.presenters;

import com.hond.mvpexample.beans.Weather;
import com.hond.mvpexample.services.APIService;
import com.hond.mvpexample.views.IWeatherView;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by hond on 11/18/2016.
 */

public class WeatherPresenterImpl implements IWeatherPresenter {
    IWeatherView mWeatherView;
    APIService mApiService;

    public WeatherPresenterImpl(IWeatherView weatherView) {
        this.mWeatherView = weatherView;
        mApiService = new APIService();
    }

    @Override
    public void loadWeather() {
        if (mWeatherView != null) {
            mWeatherView.showProgress();
        }
        mApiService.getApi()
                .getWeather(mWeatherView.getCityId())
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Weather>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Weather weather) {
                        if (mWeatherView != null)
                            mWeatherView.hideProgress();
                        mWeatherView.displayWeather(weather);
                    }
                });
    }

    @Override
    public void onDestroy() {
        mWeatherView = null;
    }
}
