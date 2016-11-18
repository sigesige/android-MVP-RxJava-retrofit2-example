package com.hond.mvpexample.models;

import com.hond.mvpexample.beans.City;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hond on 11/18/2016.
 */

public class CityModelImpl implements ICityModel {

    @Override
    public List<City> getCityIdList() {
        return getData();
    }

    //模拟从数据库等地方获得数据
    private List<City> getData() {
        List<City> cityList = new ArrayList<>();
        cityList.add(new City("101010100", "北京"));
        cityList.add(new City("101020100", "上海"));
        cityList.add(new City("101030100", "天津"));
        cityList.add(new City("101040100", "重庆"));
        cityList.add(new City("101050101", "哈尔滨"));
        cityList.add(new City("101060101", "长春"));
        cityList.add(new City("101070101", "沈阳"));
        cityList.add(new City("101080101", "呼和浩特"));
        cityList.add(new City("101090101", "石家庄"));
        cityList.add(new City("101100101", "太原"));
        cityList.add(new City("101110101", "西安"));
        cityList.add(new City("101120101", "济南"));
        cityList.add(new City("101130101", "乌鲁木齐"));
        cityList.add(new City("101140101", "拉萨"));
        cityList.add(new City("101150101", "西宁"));
        cityList.add(new City("101160101", "兰州"));
        cityList.add(new City("101170101", "银川"));
        cityList.add(new City("101180101", "郑州"));
        cityList.add(new City("101190101", "南京"));
        cityList.add(new City("101200101", "武汉"));
        cityList.add(new City("101210101", "杭州"));
        cityList.add(new City("101220101", "合肥"));
        cityList.add(new City("101230101", "福州"));
        cityList.add(new City("101240101", "南昌"));
        cityList.add(new City("101250101", "长沙"));
        cityList.add(new City("101260101", "贵阳"));
        cityList.add(new City("101270101", "成都"));
        cityList.add(new City("101280101", "广州"));
        cityList.add(new City("101280601", "深圳"));
        cityList.add(new City("101290101", "昆明"));
        cityList.add(new City("101300101", "南宁"));
        cityList.add(new City("101310101", "海口"));
        cityList.add(new City("101320101", "香港"));
        cityList.add(new City("101330101", "澳门"));
        cityList.add(new City("101340102", "台北"));
        return cityList;
    }


}
