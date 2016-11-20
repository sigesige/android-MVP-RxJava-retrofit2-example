package com.hond.mvpexample.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hond.mvpexample.R;
import com.hond.mvpexample.beans.City;

import java.util.List;

/**
 * Created by 19905 on 2016/1{1/20.
 */

public class CityAdapter  extends RecyclerView.Adapter<CityAdapter.MyViewHolder>
{
    private List<City> mDatas;
    private Context mContext;
    private LayoutInflater inflater;

    public interface OnItemClickListener{
        void onClick(String cityId);
        void onLongClick(String cityId);
    }
    OnItemClickListener mOnItemClickListener;
    public void setOnItemClickListener(OnItemClickListener onItemClickListener ){
        this. mOnItemClickListener=onItemClickListener;
    }

    public CityAdapter(Context context,List<City> list)
    {
        this.mContext = context;
        this.mDatas = list;
        this.inflater = LayoutInflater. from(mContext);
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        MyViewHolder holder = new MyViewHolder(inflater.inflate(R.layout.layout_city_item, parent,
                false));
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position)
    {
        holder.cityView.setText(mDatas.get(position).name);
        if( mOnItemClickListener!= null) {
            holder.cityView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    mOnItemClickListener.onClick(mDatas.get(position).cityId);
                }
            });

            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    mOnItemClickListener.onLongClick(mDatas.get(position).cityId);
                    return false;
                }
            });
        }
        }

    @Override
    public int getItemCount()
    {
        return mDatas.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {

        TextView cityView;

        public MyViewHolder(View view)
        {
            super(view);
            cityView = (TextView) view.findViewById(R.id.textViewCityName);
        }
    }
}
