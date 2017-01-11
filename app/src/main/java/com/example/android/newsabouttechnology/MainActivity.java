package com.example.android.newsabouttechnology;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    String link = "https://newsapi" +
            ".org/v1/articles?source=engadget&sortBy=top&apiKey=a25a3dfb39d94d448c334519daf57be2";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }


}
