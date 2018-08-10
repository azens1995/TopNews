package com.azens.news.ui;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.azens.news.BuildConfig;
import com.azens.news.R;
import com.azens.news.adapter.NewsAdapter;
import com.azens.news.api.NewsClient;
import com.azens.news.api.ServiceGenerator;
import com.azens.news.model.News;
import com.azens.news.model.NewsResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class BloombergFragment extends Fragment {

    private RecyclerView recyclerView;
    SwipeRefreshLayout swipeLayout;
    private final static String API_KEY = BuildConfig.NewsAPIKey;

    public BloombergFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_bloomberg, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        loadJSON();

        swipeLayout = view.findViewById(R.id.swipe_container);
        swipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadJSON();
                Toast.makeText(getContext(),"Refreshed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void loadJSON() {
        NewsClient client = ServiceGenerator.createService(NewsClient.class);

        Call<NewsResponse> call = client.getNews("bloomberg",API_KEY);
        call.enqueue(new Callback<NewsResponse>() {
            @Override
            public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
                List<News> news =response.body().getNews();
                recyclerView.setAdapter(new NewsAdapter(getContext(), news));
                swipeLayout.setRefreshing(false);
            }

            @Override
            public void onFailure(Call<NewsResponse> call, Throwable t) {
                Toast.makeText(getContext(), "error :(", Toast.LENGTH_SHORT).show();
            }
        });
    }


}
