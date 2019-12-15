package com.vintile.sharathkumartn_reddit.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.vintile.sharathkumartn_reddit.model.Repository;
import com.vintile.sharathkumartn_reddit.model.postmodel.Child;
import com.vintile.sharathkumartn_reddit.model.postmodel.Data_;
import com.vintile.sharathkumartn_reddit.model.postmodel.RedditPost;
import com.vintile.sharathkumartn_reddit.utils.ApiClient;
import com.vintile.sharathkumartn_reddit.utils.RetrofitAPI;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeViewModel extends AndroidViewModel {

    private static final String TAG = "HomeViewModel";
    private Repository repository;
    MutableLiveData<List<Data_>> data = new MutableLiveData<>();
    public HomeViewModel(@NonNull Application application) {
        super(application);
        repository = new Repository();

    }

    List<Child> children = new ArrayList<>();
    List<Data_> data_ = new ArrayList<>();

    public LiveData<List<Data_>> requestData(String topic, int pageCount){
        RetrofitAPI apiService =
                ApiClient.getClient().create(RetrofitAPI.class);


        Call<RedditPost> call = apiService.getPosts(topic, pageCount);
        call.enqueue(new Callback<RedditPost>() {
            @Override
            public void onResponse(@NonNull Call<RedditPost> call, @NonNull Response<RedditPost> response) {

                children.addAll(response.body().getData().getChildren());
                for (Child child : children){
                    data_.add(child.getData());
                }
                data.setValue(data_);
            }

            @Override
            public void onFailure(Call<RedditPost> call, Throwable t) {
                Log.e("Error", t.toString());
            }
        });
        return data;
    }

}
