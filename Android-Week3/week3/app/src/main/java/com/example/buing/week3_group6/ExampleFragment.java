package com.example.buing.week3_group6;

import android.content.Context;
import android.os.Handler;
import android.os.StrictMode;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Hung on 31-Mar-18.
 */

public  class ExampleFragment extends Fragment {
    private static final String type = null;
    ArrayList<MovieObject> movieO;

    public static ExampleFragment newInstance(String types) {
        Bundle args = new Bundle();
        args.putString(type, types);
        ExampleFragment fragment = new ExampleFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
                //Create adapter to recycleView

        View  view =  inflater.inflate(R.layout.recycle_view, container, false);
        String url = "";


            url = "https://api.themoviedb.org/3/movie/top_rated?api_key=a07e22bc18f5cb106bfe4cc1f83ad8ed";


        try {
            String msgMovie = (String) getURL(url);
            JSONObject jsonObject = new JSONObject(msgMovie);
            JSONArray jsonArray = jsonObject.getJSONArray("results");
            movieO = new ArrayList<>();
            Gson gson = new Gson();
            for (int i = 0; i<jsonArray.length();i++){
                JSONObject finalObject = jsonArray.getJSONObject(i);
                MovieObject movie = gson.fromJson(finalObject.toString(),MovieObject.class);
                movieO.add(movie);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        //Reload
        final SwipeRefreshLayout swipeRefreshLayout=(SwipeRefreshLayout) view.findViewById(R.id.swipeContainer);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener()
        {
            @Override
            public void onRefresh()
            {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        swipeRefreshLayout.setRefreshing(true);
                        getDuLieu g = new getDuLieu();
                        movieO = g.getData();
                        swipeRefreshLayout.setRefreshing(false);
                    }
                },3000);
            }
        });
        //reload


        //Set recycleView adapter
        RecyclerView recyclerView =  view.findViewById(R.id.recycleView);
        MovieAdapter movieAdapter = new MovieAdapter( movieO,this.getContext());
        recyclerView.setAdapter(movieAdapter);

//             Set LayoutManager for View
        LinearLayoutManager linearLayoutManager = new
                LinearLayoutManager(this.getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        //Custom Design View in Layout Manager
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this.getContext(),
                linearLayoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);


        return view;
    }

    public static String getURL(String surl) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        System.setProperty("java.net.preferIPv4Addresses", "true");
        System.setProperty("java.net.preferIPv6Addresses", "false");
        System.setProperty("validated.ipv6", "false");
        String fullString = "";
        try {

            URL url = new URL(surl);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                fullString += line;
            }
            reader.close();
        } catch (Exception ex) {
            //showDialog("Verbindungsfehler.",parent);
        }
        return fullString;
    }
}
