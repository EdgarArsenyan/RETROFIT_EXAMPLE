package com.noringerazancutyun.retrofit_example.UI;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.noringerazancutyun.retrofit_example.Adapter.RecyclerViewAdapter;
import com.noringerazancutyun.retrofit_example.Model.MovieModel;
import com.noringerazancutyun.retrofit_example.Model.MovieViewModel;
import com.noringerazancutyun.retrofit_example.R;
import com.noringerazancutyun.retrofit_example.Util.NetworkUtils;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private LinearLayoutManager linearLayoutManager;
    private RecyclerViewAdapter adapter;
    private RecyclerView recyclerView;
    private List<MovieModel> modelList = new ArrayList<>();
    private MovieViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRecycler();
        initViewModel();
    }

    private void initRecycler() {
        recyclerView = findViewById(R.id.recycler);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new RecyclerViewAdapter(modelList, this);
        recyclerView.setAdapter(adapter);
    }

    private void initViewModel() {
        if (NetworkUtils.isNetworkAvailable(this)) {
            viewModel = ViewModelProviders.of(this).get(MovieViewModel.class);
            viewModel.getFromRepo();
            viewModel.getMovieList().observe(this, new Observer<List<MovieModel>>() {
                @Override
                public void onChanged(@Nullable List<MovieModel> movieModels) {
                    modelList.addAll(movieModels);
                    adapter.notifyDataSetChanged();
                }
            });
        }
    }
}
