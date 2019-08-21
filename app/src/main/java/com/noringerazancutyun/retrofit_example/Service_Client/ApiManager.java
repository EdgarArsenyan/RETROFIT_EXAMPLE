package com.noringerazancutyun.retrofit_example.Service_Client;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiManager {

    public static final String BASE_URL = "https://api.androidhive.info";
    public static RetrofitService mApiClient;

    public static RetrofitService getmApiClient() {

        if (mApiClient == null) {

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            mApiClient = retrofit.create(RetrofitService.class);
        }
        return mApiClient;
    }
}
