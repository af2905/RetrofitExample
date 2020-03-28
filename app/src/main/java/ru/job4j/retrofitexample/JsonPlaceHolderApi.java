package ru.job4j.retrofitexample;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi {
    @GET("comments")
    Call<List<Comment>> getComments();

    Retrofit RETROFIT = new Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/posts/1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
