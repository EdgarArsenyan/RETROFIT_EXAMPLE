package com.noringerazancutyun.retrofit_example.UI;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.noringerazancutyun.retrofit_example.R;

public class ItemActivity extends AppCompatActivity {

    private String itemImageUrl;
    private String itemTitle;
    private String itemRelease;
    private String itemRating;
    private String itemGenre;
    private ImageView itemImageView;
    private TextView itemTitleTV;
    private TextView itemGenreTV;
    private TextView itemReleaseTV;
    private TextView itemRatingTV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        init();
        getResult();
        showResult();
    }

    private void init() {
        itemTitleTV = findViewById(R.id.itemTitle);
        itemGenreTV = findViewById(R.id.itemGenre);
        itemRatingTV = findViewById(R.id.itemRating);
        itemReleaseTV = findViewById(R.id.itemRelease);
        itemImageView = findViewById(R.id.itemImage);
    }


    private void getResult() {

        Intent intent = getIntent();
        itemTitle = intent.getStringExtra("title");
        itemRelease = intent.getStringExtra("release");
        itemImageUrl = intent.getStringExtra("imageUrl");
        itemRating = intent.getStringExtra("rating");
        itemGenre = intent.getStringExtra("genre");
    }

    private void showResult() {

        itemReleaseTV.setText("   " + itemRelease);
        itemRatingTV.setText("   " + itemRating);
        itemGenreTV.setText("   " + itemGenre);
        itemTitleTV.setText("   " + itemTitle);

        Glide.with(this)
                .load(itemImageUrl)
                .into(itemImageView);
    }
}
