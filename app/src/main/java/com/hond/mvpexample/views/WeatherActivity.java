package com.hond.mvpexample.views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.hond.mvpexample.R;
import com.hond.mvpexample.Utils.UtilFunction;
import com.hond.mvpexample.beans.Weather;
import com.hond.mvpexample.presenters.IWeatherPresenter;
import com.hond.mvpexample.presenters.WeatherPresenterImpl;

/**
 * Created by hond on 11/18/2016.
 */

public class WeatherActivity extends AppCompatActivity implements IWeatherView {
    private TextView mWeatherTextView;
    private IWeatherPresenter mWeatherPresenterImpl;
    private String cityId;
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        setTitle(R.string.title_weather);
        cityId = getIntent().getStringExtra("cityId");
        mProgressBar = UtilFunction.createProgressBar(this);
        mWeatherTextView = (TextView) findViewById(R.id.textViewWeather);

        mWeatherPresenterImpl = new WeatherPresenterImpl(this);
        mWeatherPresenterImpl.loadWeather();
    }

    @Override
    public void showProgress() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void displayWeather(Weather weather) {

        mWeatherTextView.setText(
                "city: " + weather.getWeatherinfo().city + "\n"
                        + "time: " + weather.getWeatherinfo().time + "\n"
                        + "temperature: " + weather.getWeatherinfo().temp + "\n"
                        + "wind: " + weather.getWeatherinfo().WD + " " + weather.getWeatherinfo().WS + "\n"
                        + "humidity: " + weather.getWeatherinfo().SD + "\n"
        );
    }

    @Override
    public String getCityId() {
        return cityId;
    }

    @Override
    protected void onDestroy() {
        mWeatherPresenterImpl.onDestroy();
        super.onDestroy();
    }
}
