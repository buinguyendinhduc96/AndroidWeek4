package com.example.buing.week3_group6;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

public class MovieInterface extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_interface);

        //Connect to xml-file
        ImageView imgBackDrop = (ImageView) findViewById(R.id.imgBackView);
        TextView tvTittle = (TextView) findViewById(R.id.tvTittleDetail);
        TextView tvReleaseDay = (TextView) findViewById(R.id.tvReleaseDay);
        RatingBar rtBar = (RatingBar) findViewById(R.id.rtBar);
        TextView tvOverview = (TextView) findViewById(R.id.tvDescription);

        Movie movie = (Movie) Parcels.unwrap(getIntent().getParcelableExtra("key_movie"));

        Intent intent = this.getIntent();

        tvTittle.setText(movie.getTitle());
        Picasso.with(this).load("http://image.tmdb.org/t/p/w500/"
                + movie.getBackdrop_path()).into(imgBackDrop);
        tvReleaseDay.setText("Release Day: " + movie.getRelease_date());
        tvOverview.setText(movie.getOverview());
        tvOverview.setMovementMethod(new ScrollingMovementMethod());
        float score = Float.parseFloat(movie.getVote_average());
        rtBar.setRating(score/2);




//        tvTittle.setText(intent.getExtras().getString("key_tittle"));
//        Picasso.with(this).load("http://image.tmdb.org/t/p/w500/"
//                + intent.getExtras().getString("key_imgBackDrop")).into(imgBackDrop);
//        tvReleaseDay.setText("Release Day: " + intent.getExtras().getString("key_releaseDay"));
//        tvOverview.setText(intent.getExtras().getString("key_description"));
//        tvOverview.setMovementMethod(new ScrollingMovementMethod());
//        float score = Float.parseFloat(intent.getExtras().getString("key_voteAvarage"));
//        rtBar.setRating(score/2);

    }
}
