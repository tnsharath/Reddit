package com.vintile.sharathkumartn_reddit.model;

import android.util.Log;

import androidx.annotation.NonNull;

import com.vintile.sharathkumartn_reddit.model.postmodel.Child;
import com.vintile.sharathkumartn_reddit.model.postmodel.RedditPost;
import com.vintile.sharathkumartn_reddit.utils.ApiClient;
import com.vintile.sharathkumartn_reddit.utils.RetrofitAPI;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Repository {

    List<Child> children = new ArrayList<>();

    public List<Child> getData(String topic, int pageCount) {

        RetrofitAPI apiService =
                ApiClient.getClient().create(RetrofitAPI.class);


        Call<RedditPost> call = apiService.getPosts(topic, pageCount);
        call.enqueue(new Callback<RedditPost>() {
            @Override
            public void onResponse(@NonNull Call<RedditPost> call, @NonNull Response<RedditPost> response) {

                Log.e("Success", response.body().getKind());
                children.addAll(response.body().getData().getChildren());
                Log.e("Success",String.valueOf(children.size()));
            }

            @Override
            public void onFailure(Call<RedditPost> call, Throwable t) {
                Log.e("Error", t.toString());
            }
        });
        return children;
    }
}
