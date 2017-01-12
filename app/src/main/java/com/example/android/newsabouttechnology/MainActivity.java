package com.example.android.newsabouttechnology;

import android.app.LoaderManager;
import android.content.Context;
import android.content.Loader;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.List;

import static android.R.id.list;

public class MainActivity extends AppCompatActivity
        implements LoaderManager.LoaderCallbacks<List<News>> {
    private static final String TAG = "MainActivity";
    private static final String URL= "https://newsapi" +
            ".org/v1/articles?source=engadget&sortBy=top&apiKey=a25a3dfb39d94d448c334519daf57be2";
    private static final int EARTHQUAKE_LOADER_ID = 1;

    List<News> hao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate: START");

        setContentView(R.layout.activity_main);

        
        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected()) {
            LoaderManager loaderManager = getLoaderManager();
            loaderManager.initLoader(EARTHQUAKE_LOADER_ID, null, this);

        } else {

        }
        Log.i(TAG, "onCreate: drukujem");

        System.out.println(hao.toString());

        Log.i(TAG, "onCreate: END");

    }


    @Override
    public Loader<List<News>> onCreateLoader(int id, Bundle args) {
        Log.i(TAG, "onCreateLoader: START");

        NewsLoader newsloader = new NewsLoader(this,URL);
        hao  = newsloader.getListOfNews();
        Log.i(TAG, "onCreateLoader: list: " + list);
        Log.i(TAG, "onCreateLoader: END");

        return newsloader;
    }

    @Override
    public void onLoadFinished(Loader<List<News>> loader, List<News> data) {
        Log.i(TAG, "onLoadFinished: START");

    }

    @Override
    public void onLoaderReset(Loader<List<News>> loader) {

    }
}
