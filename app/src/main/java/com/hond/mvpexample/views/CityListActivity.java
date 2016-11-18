package com.hond.mvpexample.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.hond.mvpexample.R;
import com.hond.mvpexample.Utils.UtilFunction;
import com.hond.mvpexample.adapters.CitiesAdapter;
import com.hond.mvpexample.beans.City;
import com.hond.mvpexample.presenters.CityListPresenterImpl;

import java.util.List;

/**
 * Created by hond on 11/18/2016.
 */

public class CityListActivity extends AppCompatActivity implements ICityListView, AdapterView.OnItemClickListener {
    private ListView mListViewCities;
    private CitiesAdapter mCitiesAdapter;
    private CityListPresenterImpl mCityListImpl;
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_list);
        setTitle(R.string.title_choose_city);
        mProgressBar = UtilFunction.createProgressBar(this);
        mListViewCities = (ListView) findViewById(R.id.cityListView);

        mListViewCities.setOnItemClickListener(this);

        mCitiesAdapter = new CitiesAdapter(this);
        mListViewCities.setAdapter(mCitiesAdapter);

        mCityListImpl = new CityListPresenterImpl(this);
        mCityListImpl.loadCities();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        City city = mCitiesAdapter.getItem(position);
        String cityId = city.cityId;
        Intent detailIntent = new Intent(this, WeatherActivity.class);
        detailIntent.putExtra("cityId", cityId);
        startActivity(detailIntent);
    }

    @Override
    public void displayCities(List<City> cityList) {
        mCitiesAdapter.clear();
        mCitiesAdapter.addAll(cityList);
        mCitiesAdapter.notifyDataSetInvalidated();
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
    protected void onDestroy() {
        mCityListImpl.onDestroy();
        super.onDestroy();
    }
}
