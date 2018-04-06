package com.example.buing.week3_group6;

import android.app.Application;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class MyApp extends Application {

    public static  String msgMovie  ;
    public  final String TAG = MyApp.class.getSimpleName();

    public MyApp(){
        String data ;
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
                    msgMovie = response.body().string();
                    setMessage(msgMovie);
                }
            }
        });
    }

//    @Override
//    public void onCreate() {
//        super.onCreate();
//    }


    public void setMessage(String m){
        this.msgMovie = m;
    }

    public static String getMessage(){
        return msgMovie;
    }
}
