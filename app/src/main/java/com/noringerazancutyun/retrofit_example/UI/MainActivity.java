package com.noringerazancutyun.retrofit_example.UI;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.noringerazancutyun.retrofit_example.Adapter.RecyclerViewAdapter;
import com.noringerazancutyun.retrofit_example.Model.MovieModel;
import com.noringerazancutyun.retrofit_example.R;
import com.noringerazancutyun.retrofit_example.Service_Client.ApiManager;
import com.noringerazancutyun.retrofit_example.Util.NetworkUtils;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private LinearLayoutManager linearLayoutManager;
    private RecyclerViewAdapter adapter;
    private RecyclerView recyclerView;
    private List<MovieModel> modelList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRecycler();
        getResponce();
    }

    private void initRecycler() {
        recyclerView = findViewById(R.id.recycler);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new RecyclerViewAdapter(modelList, this);
        recyclerView.setAdapter(adapter);
    }


    public void getResponce() {

        if (NetworkUtils.isNetworkAvailable(this)) {

            try {
                Call<List<MovieModel>> call = ApiManager.getmApiClient().getData();
                call.enqueue(new Callback<List<MovieModel>>() {

                    @Override
                    public void onResponse(Call<List<MovieModel>> call, Response<List<MovieModel>> response) {
                        for (int i = 0; i < response.body().size(); i++) {
                            modelList.add(response.body().get(i));
                        }
                        adapter.notifyDataSetChanged();
                    }
                    @Override
                    public void onFailure(Call<List<MovieModel>> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "Downloading Error", Toast.LENGTH_SHORT).show();
                    }
                });
            } catch (Exception e) {
                Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
            }
        }
    }
}
