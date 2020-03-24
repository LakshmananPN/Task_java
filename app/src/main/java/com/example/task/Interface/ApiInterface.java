package com.example.task.Interface;


import com.example.task.Model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {
    // @GET("posts")

    //Call<List<pojo_class>> getpojo();

@POST("posts")
    Call<Post>createPost(@Body Post post);
}


