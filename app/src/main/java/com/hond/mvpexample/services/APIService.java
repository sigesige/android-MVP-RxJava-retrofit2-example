package com.hond.mvpexample.services;

import com.hond.mvpexample.beans.Weather;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;


public class APIService {

    private static final String API_SERVER_URL = "http://www.weather.com.cn/";
    private ExecuteApi mExecuteApi;

    public APIService() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(okHttpClient)
                .baseUrl(API_SERVER_URL)
                .build();

        mExecuteApi = retrofit.create(ExecuteApi.class);
    }

    public ExecuteApi getApi() {
        return mExecuteApi;
    }

    public interface ExecuteApi {
        @Headers({
                "Accept:application/json"
        })
        @GET("adat/sk/{cityCode}.html")
        Observable<Weather> getWeather(@Path("cityCode") String cityCode);
    }
}
