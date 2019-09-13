package com.noringerazancutyun.retrofit_example.Repo;

import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.noringerazancutyun.retrofit_example.Model.MovieModel;
import com.noringerazancutyun.retrofit_example.Service_Client.ApiManager;
import com.noringerazancutyun.retrofit_example.Service_Client.RetrofitService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieRepository {

    private static MovieRepository repository;
    private RetrofitService service;

    public MovieRepository() {
        service = ApiManager.getmApiClient();
    }

    public static MovieRepository getInstance(){
        if (repository ==null){
            repository = new MovieRepository();
        }
        return repository;
    }

    public MutableLiveData<List<MovieModel>> getMovieList(){
        final MutableLiveData<List<MovieModel>> model = new MutableLiveData<>();
        Call<List<MovieModel>> call = service.getData();
        call.enqueue(new Callback<List<MovieModel>>() {
            @Override
            public void onResponse(Call<List<MovieModel>> call, Response<List<MovieModel>> response) {
                if(response.body() !=null && response.isSuccessful()){
                    model.setValue((response.body()));
                }
            }

            @Override
            public void onFailure(Call<List<MovieModel>> call, Throwable t) {
                Log.e("Call error", "Download E#rror");
            }
        });
        return  model;
    }
}
