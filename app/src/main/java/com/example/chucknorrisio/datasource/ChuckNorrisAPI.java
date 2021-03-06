package com.example.chucknorrisio.datasource;

import com.example.chucknorrisio.model.Joke;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ChuckNorrisAPI {

    static final String BASE_URL = "https://api.chucknorris.io/";

    @GET("jokes/random")
    Call<Joke> findRandomBy(@Query("category") String category);

    @GET("jokes/categories")
    Call<List<String>> findAll();

}
