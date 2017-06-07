package com.example.geniusplaza.sample.retrofit;

import com.example.geniusplaza.sample.POJO.Posts;

import java.util.List;


import io.reactivex.Observable;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


/**
 * Created by geniusplaza on 6/6/17.
 */

public interface ExampleApi {

    @GET("/posts")
    Observable<List<Posts>> getAllPosts();


}
