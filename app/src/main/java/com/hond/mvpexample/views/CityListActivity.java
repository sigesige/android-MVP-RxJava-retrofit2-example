package com.hond.mvpexample.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.hond.mvpexample.R;
import com.hond.mvpexample.Utils.UtilFunction;
import com.hond.mvpexample.adapters.CityAdapter;
import com.hond.mvpexample.adapters.DividerItemDecoration;
import com.hond.mvpexample.beans.City;
import com.hond.mvpexample.presenters.CityListPresenterImpl;

import java.util.List;

/**
 * Created by hond on 11/18/2016.
 */

public class CityListActivity extends AppCompatActivity implements ICityListView {
    private CityAdapter mCityAdapter;
    private CityListPresenterImpl mCityListImpl;
    private ProgressBar mProgressBar;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_list);
        setTitle(R.string.title_choose_city);
        mProgressBar = UtilFunction.createProgressBar(this);
        mRecyclerView = (RecyclerView) findViewById(R.id.cityListRecyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        mCityListImpl = new CityListPresenterImpl(this);
        mCityListImpl.loadCities();
        mCityAdapter.setOnItemClickListener(new CityAdapter.OnItemClickListener() {
            @Override
            public void onLongClick(String cityId) {

            }

            @Override
            public void onClick(String cityId) {
                Intent detailIntent = new Intent(CityListActivity.this, WeatherActivity.class);
                detailIntent.putExtra("cityId", cityId);
                startActivity(detailIntent);
            }
        });
    }


    @Override
    public void addDataToAdapter(List<City> list) {
        mCityAdapter = new CityAdapter(this, list);
        mRecyclerView.setAdapter(mCityAdapter);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
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
