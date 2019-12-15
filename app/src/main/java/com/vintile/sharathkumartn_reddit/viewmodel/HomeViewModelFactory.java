package com.vintile.sharathkumartn_reddit.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.vintile.sharathkumartn_reddit.MyApplication;

public class HomeViewModelFactory implements ViewModelProvider.Factory{

    @SuppressWarnings("unchecked")
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {

        if (modelClass.isAssignableFrom(HomeViewModel.class)) {
            return (T) new HomeViewModel(MyApplication.getContext());
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
