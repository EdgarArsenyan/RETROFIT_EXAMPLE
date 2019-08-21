package com.noringerazancutyun.retrofit_example.Service_Client;

import com.noringerazancutyun.retrofit_example.Model.MovieModel;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitService {

@GET("json/movies.json")
    Call<List<MovieModel>> getData();
}
