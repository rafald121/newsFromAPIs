package com.example.android.newsabouttechnology;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by Rafaello on 2017-01-12.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.MyViewHolder> {

    private static final String TAG = "NewsAdapter";
    
    private List<News> newsList;

    public NewsAdapter(List<News> newsList) {
        Log.i(TAG, "NewsAdapter: START");
        this.newsList = newsList;
        Log.i(TAG, "NewsAdapter: END");
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.i(TAG, "onCreateViewHolder: START");
        View recyclerItem = LayoutInflater.from(parent.getContext()).inflate(R.layout
                .recycler_item, parent, false);
        Log.i(TAG, "onCreateViewHolder: END");
        return new MyViewHolder(recyclerItem);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Log.i(TAG, "onBindViewHolder: START");
        News news = newsList.get(position);

        Log.i(TAG, "onBindViewHolder: news z listy: " + news.toString());
        
        holder.title.setText(news.getTitle());
        holder.author.setText(news.getAuthor());
        //TODO sprobować zmienić na publishedDate w News.java
        holder.publishedDate.setText(news.getPublishedAt());

        Log.i(TAG, "onBindViewHolder: END");
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        private static final String TAG = "MyViewHolder";
        
        public ImageView imageView;
        public TextView title, author, publishedDate;
        public ImageButton expand, goToUrl;

        public MyViewHolder(View itemView){

            super(itemView);
            Log.i(TAG, "MyViewHolder: START");
            imageView = (ImageView) itemView.findViewById(R.id.recycler_view_image);

            title = (TextView) itemView.findViewById(R.id.recycler_item_title);
            author = (TextView) itemView.findViewById(R.id.recycler_view_author);
            publishedDate = (TextView) itemView.findViewById(R.id.recycler_view_publishedDate);

            expand = (ImageButton) itemView.findViewById(R.id.recycler_view_expand);
            goToUrl = (ImageButton) itemView.findViewById(R.id.recycler_view_goToUrl);
            Log.i(TAG, "MyViewHolder: END");
            
        }


    }



}
