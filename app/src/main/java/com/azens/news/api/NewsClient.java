package com.azens.news.api;

import com.azens.news.model.NewsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Azens Eklak on 8/7/18.
 */
public interface NewsClient {

    @GET("top-headlines")
    Call<NewsResponse> getNews(@Query("sources") String source, @Query("apiKey") String API_KEY);

//    @GET("top-headlines?sources=bbc-news&apiKey=f8302b23c2a24f529323e2e69515556e")
//    Call<NewsResponse> getBBCNews();
//
//    @GET("top-headlines?sources=bloomberg&apiKey=f8302b23c2a24f529323e2e69515556e")
//    Call<NewsResponse> getBloombergNews();
}
