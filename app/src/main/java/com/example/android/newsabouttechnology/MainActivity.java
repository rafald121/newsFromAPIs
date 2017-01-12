package com.example.android.newsabouttechnology;

import android.app.LoaderManager;
import android.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<Earthquake>> {

    String link = "https://newsapi" +
            ".org/v1/articles?source=engadget&sortBy=top&apiKey=a25a3dfb39d94d448c334519daf57be2";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NewsLoader newsLoader = new NewsLoader(this, link);



    }


    @Override
    public Loader<List<Earthquake>> onCreateLoader(int id, Bundle args) {
        return null;
    }

    @Override
    public void onLoadFinished(Loader<List<Earthquake>> loader, List<Earthquake> data) {

    }

    @Override
    public void onLoaderReset(Loader<List<Earthquake>> loader) {

    }
}
