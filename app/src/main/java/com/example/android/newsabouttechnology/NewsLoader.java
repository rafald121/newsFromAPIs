package com.example.android.newsabouttechnology;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.os.AsyncTask;

import java.util.List;

/**
 * Created by Rafaello on 2017-01-11.
 */

public class NewsLoader extends AsyncTaskLoader<List<News>> {

    private static final String TAG = "NewsLoader";
    private String mUrl;

    public NewsLoader(Context context, String url) {
        super(context);
        mUrl=url;
    }

//    TODO co zmienia forceLoad \/
    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<News> loadInBackground() {
        if(mUrl == null){
            return null;
        }
//        TODO: fetch from internet: \/
//        List <News> newsList =
    }
}
