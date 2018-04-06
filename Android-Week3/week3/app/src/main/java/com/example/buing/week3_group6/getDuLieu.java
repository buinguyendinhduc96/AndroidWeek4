package com.example.buing.week3_group6;

import android.app.Activity;
import android.app.Application;
import android.graphics.Movie;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ActivityChooserView;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class getDuLieu extends Application {
    ArrayList<MovieObject> movieO = new ArrayList<MovieObject>();
    public getDuLieu(){

    }


    public ArrayList<MovieObject> getData(){
        SwipeRefreshLayout swipeContainer;

        //   RecyclerView recyclerView = findViewById(R.id.recycleView);
//Transform from json to POJOs
        OkHttpClient client = new OkHttpClient();
        String url = "https://api.themoviedb.org/3/movie/now_playing?api_key=a07e22bc18f5cb106bfe4cc1f83ad8ed";
        Request request = new Request.Builder().url(url).build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {

                    JSONArray jsonArray = null;
                    try {

                        //String  data = response.body().string();
                        String data = null;
                        MyApp ma = new MyApp();
                        data = ma.getMessage();
                        JSONObject jsonObject = new JSONObject(data);
                        jsonArray = jsonObject.getJSONArray("results");
                        movieO = new ArrayList<>();
                        Gson gson = new Gson();
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject finalObject = jsonArray.getJSONObject(i);
                            MovieObject movie = gson.fromJson(finalObject.toString(), MovieObject.class);
                            movieO.add(movie);
                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }
        });
        return movieO;
    }
}

