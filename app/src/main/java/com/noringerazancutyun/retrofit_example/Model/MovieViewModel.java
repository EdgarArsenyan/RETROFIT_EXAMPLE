package com.noringerazancutyun.retrofit_example.Model;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.noringerazancutyun.retrofit_example.Repo.MovieRepository;

import java.util.List;

public class MovieViewModel extends ViewModel {

    private MutableLiveData<List<MovieModel>> movieModel;
    private MovieRepository repository;

    public void getFromRepo(){
        if (movieModel != null){
            return;
        }
        repository = MovieRepository.getInstance();
    }

    public LiveData<List<MovieModel>> getMovieList() {
        movieModel = repository.getMovieList();
        return movieModel;
    }
}
