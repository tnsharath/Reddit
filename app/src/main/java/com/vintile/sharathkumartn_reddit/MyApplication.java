package com.vintile.sharathkumartn_reddit;

import android.app.Application;

public class MyApplication extends Application {
    private static MyApplication mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }

    public static MyApplication getContext() {
        return mContext;
    }
}
