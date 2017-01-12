package com.example.android.newsabouttechnology;

import android.app.LoaderManager;
import android.content.Context;
import android.content.Loader;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.List;

import static android.R.attr.data;
import static android.R.id.list;


public class MainActivity extends AppCompatActivity
        implements LoaderManager.LoaderCallbacks<List<News>> {
    private static final String TAG = "MainActivity";
    private static final String URL= "https://newsapi.org/v1/articles?source=national-geographic&sortBy=top&apiKey=a25a3dfb39d94d448c334519daf57be2";
    private static final int EARTHQUAKE_LOADER_ID = 1;

    RecyclerView recyclerView;
    NewsAdapter newsAdapter;
    List<News> newsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate: START");

        setContentView(R.layout.activity_main);


        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);


        if(newsList!=null) {
            newsAdapter = new NewsAdapter(newsList);
            Log.i(TAG, "onCreate: stworzono obiekt newsAdapter z listą, lista nie jest pusta");
        } else {
            Log.i(TAG, "onCreate: lista w adapterze jest pusta");
        }
    


        
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



        if(data!=null) {
            newsList = data;
            Log.i(TAG, "onLoadFinished: listaZNewsami: " + newsList.toString());
        }
        else
            Log.e(TAG, "onLoadFinished: HAO IS NULL" );

        Log.i(TAG, "onLoadFinished: lista do adaptera");



        newsAdapter = new NewsAdapter(newsList);

        recyclerView.setHasFixedSize(true);//czy bedzie miala zmienny rozmiar podczas dzialania apki
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);

        recyclerView.setAdapter(newsAdapter);


        Log.i(TAG, "onLoadFinished: po liscie do adaptera");
        newsAdapter.notifyDataSetChanged(); 
        Log.i(TAG, "onLoadFinished: END");
    }

    @Override
    public void onLoaderReset(Loader<List<News>> loader) {

    }
}
