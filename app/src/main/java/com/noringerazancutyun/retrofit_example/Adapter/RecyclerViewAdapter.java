package com.noringerazancutyun.retrofit_example.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.noringerazancutyun.retrofit_example.Model.MovieModel;
import com.noringerazancutyun.retrofit_example.R;
import com.noringerazancutyun.retrofit_example.UI.ItemActivity;
import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewAdapter> {

    private List<MovieModel> model;
    private Context context;

    public RecyclerViewAdapter(List<MovieModel> model, Context context) {
        this.model = model;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewAdapter onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.recycler_layout, viewGroup, false);
        return new MyViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewAdapter myViewAdapter, int i) {

        myViewAdapter.itemTitle.setText(model.get(i).getTitle());
        myViewAdapter.imageUrl = model.get(i).getImage();
        myViewAdapter.itemReleaseTV.setText("   " + model.get(i).getReleaseYear());
        myViewAdapter.itemRatingTV.setText("   " + (model.get(i).getRating()));
        myViewAdapter.itemRating = toString().valueOf(model.get(i).getRating());
        myViewAdapter.itemReleas = toString().valueOf(model.get(i).getReleaseYear());

        // List Strings to convert String Vatue for Janre TextView
        ArrayList<String> list = (ArrayList<String>) model.get(i).getGenre();
        String listString = "";
        for (String s : list) {
            listString += s + ",   ";
        }
        myViewAdapter.itemGenre = (listString);

        Glide.with(context)
                .load(myViewAdapter.imageUrl)
                .centerCrop()
                .into(myViewAdapter.itemImage);
    }

    @Override
    public int getItemCount() {
        return model.size();
    }

    public class MyViewAdapter extends RecyclerView.ViewHolder {

        TextView itemTitle;
        ImageView itemImage;
        TextView itemRatingTV;
        TextView itemReleaseTV;
        String imageUrl;
        String itemGenre;
        String itemReleas;
        String itemRating;

        public MyViewAdapter(final View itemView) {
            super(itemView);
            itemTitle = itemView.findViewById(R.id.title_recycler);
            itemImage = itemView.findViewById(R.id.image_recycler);
            itemRatingTV = itemView.findViewById(R.id.rating_recycler);
            itemReleaseTV = itemView.findViewById(R.id.release_recycler);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, ItemActivity.class);
                    intent.putExtra("title", itemTitle.getText());
                    intent.putExtra("release", itemReleas);
                    intent.putExtra("genre", itemGenre);
                    intent.putExtra("rating", itemRating);
                    intent.putExtra("imageUrl", imageUrl);
                    context.startActivity(intent);
                }
            });
        }
    }
}
