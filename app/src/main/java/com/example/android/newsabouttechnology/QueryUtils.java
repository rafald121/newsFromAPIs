package com.example.android.newsabouttechnology;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.sql.Struct;
import java.util.List;

/**
 * Created by Rafaello on 2017-01-11.
 */

public final class QueryUtils {
    private static final String TAG = QueryUtils.class.getSimpleName();


    private QueryUtils() {
    }

    public static List<News> fetchDataFromPage(String requestedUrl){
        Log.i(TAG, "fetchDataFromPage: START");
        URL url = createURL(requestedUrl);

        String jsonResponse = null;

        try{
            jsonResponse = makeHttpRequest(url);
        } catch (IOException e){
            e.printStackTrace();
            Log.e(TAG, "fetchDataFromPage: Problem while making HTTP request", e);
        }

        List<News> listOfNews = extractDataFromJson(jsonResponse);


        Log.i(TAG, "fetchDataFromPage: END");
        return listOfNews;
    }



    private static URL createURL(String requestedUrl) {
        Log.i(TAG, "createURL: START");
        URL url = null;
        try {
            url = new URL(requestedUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            Log.e(TAG, "createURL: problem while creating URL from String", e);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.i(TAG, "createURL: END");
        return url;
    }

    private static String makeHttpRequest(URL url) throws IOException {
        Log.i(TAG, "makeHttpRequest: START");
        String jsonResponse = "";

        if(url == null){
            return jsonResponse;
        }

        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;

        try{
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setReadTimeout(10000 /* milliseconds */);
            urlConnection.setConnectTimeout(15000 /* milliseconds */);
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            if(urlConnection.getResponseCode() == 200){
                inputStream = urlConnection.getInputStream();
                jsonResponse = readFromStream(inputStream);
            } else{
                Log.e(TAG, "makeHttpRequest: error while getting input stream. error code: "+ urlConnection.getResponseCode());
            }
        } catch (IOException e) {
            e.printStackTrace();
            Log.e(TAG, "makeHttpRequest: Problem while retrieving the JSON from your URL", e);
        } finally {
            if (urlConnection != null){
                urlConnection.disconnect();
            }
            if (inputStream != null){
                inputStream.close();
            }
        }
        Log.i(TAG, "makeHttpRequest: END");

        return jsonResponse;
    }

    private static String readFromStream(InputStream inputStream) throws IOException {
        Log.i(TAG, "readFromStream: START");
        StringBuilder jsonOutput = new StringBuilder();
        if(inputStream != null){
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset
                    .forName("UTF-8"));
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line = reader.readLine();
            while( line != null){
                jsonOutput.append(line);
                line = reader.readLine();
            }
        }
        Log.i(TAG, "readFromStream: END");
        return jsonOutput.toString();
    }


    private static List<News> extractDataFromJson(String jsonResponse) {
        List<News> list = null;


        return list;
    }
}
