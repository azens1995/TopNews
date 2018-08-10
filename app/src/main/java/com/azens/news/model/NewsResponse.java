package com.azens.news.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Azens Eklak on 8/7/18.
 */
public class NewsResponse {
    @SerializedName("articles")
    @Expose
    private List<News> news;

    public List<News> getNews() {
        return news;
    }

    public void setNews(List<News> news) {
        this.news = news;
    }
}
