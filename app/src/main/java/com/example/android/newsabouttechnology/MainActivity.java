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
import android.widget.Button;

import java.util.List;

import static android.R.attr.data;
import static android.R.id.list;


public class MainActivity extends AppCompatActivity
        implements LoaderManager.LoaderCallbacks<List<News>> {
    private static final String TAG = "MainActivity";
    private static final String URL= "https://newsapi" +
            ".org/v1/articles?source=engadget&sortBy=top&apiKey=a25a3dfb39d94d448c334519daf57be2";
    private static final int EARTHQUAKE_LOADER_ID = 1;

    Button button;

    List<News> newsList;

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
            Log.e(TAG, "onCreate: ŁADUJE INFO" );
        }


        Log.i(TAG, "onCreate: END");

    }




    @Override
    public Loader<List<News>> onCreateLoader(int id, Bundle args) {
        Log.i(TAG, "onCreateLoader: START");

        NewsLoader newsloader = new NewsLoader(this,URL);

        Log.i(TAG, "onCreateLoader: END");

        return newsloader;
    }

    @Override
    public void onLoadFinished(Loader<List<News>> loader, List<News> data) {
        Log.i(TAG, "onLoadFinished: START");

        if(newsList!=null)
            newsList = data;
        else
            Log.e(TAG, "onLoadFinished: HAO IS NULL" );

        Log.i(TAG, "onLoadFinished: listaZNewsami: " + newsList.toString());


    }

    @Override
    public void onLoaderReset(Loader<List<News>> loader) {

    }
}
