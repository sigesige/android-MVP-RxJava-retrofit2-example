package com.hond.mvpexample.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.hond.mvpexample.R;
import com.hond.mvpexample.beans.City;

import java.util.ArrayList;

/**
 * Created by hond on 11/18/2016.
 */

public class CitiesAdapter extends ArrayAdapter<City> {

    public CitiesAdapter(Context ctx) {
        super(ctx, 0, new ArrayList<City>());
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CitiesAdapter.ViewHolder viewHolder = null;
        City city = getItem(position);

        if(convertView == null)
        {
            viewHolder = new CitiesAdapter.ViewHolder();
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.layout_city_item, parent, false);
            viewHolder.view = (TextView) convertView.findViewById(com.hond.mvpexample.R.id.textViewCityName);
            convertView.setTag(viewHolder);
        }
        else
        {
            viewHolder = (CitiesAdapter.ViewHolder)convertView.getTag();
        }
        viewHolder.view.setText(city.name);

        return convertView;
    }

    private class ViewHolder
    {
        TextView view;
    }
}