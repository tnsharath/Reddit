package com.vintile.sharathkumartn_reddit.utils;

import com.vintile.sharathkumartn_reddit.model.postmodel.RedditPost;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RetrofitAPI {

    @GET("r/{query}/.json")
    Call<RedditPost> getPosts(@Path("query") String topic, @Query("limit") int pageCount);
}
