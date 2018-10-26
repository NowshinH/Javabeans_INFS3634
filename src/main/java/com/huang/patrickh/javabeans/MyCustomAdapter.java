package com.huang.patrickh.javabeans;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

//Adapter class to render listview
public class MyCustomAdapter extends BaseAdapter {

    Activity activity;
    ArrayList<VideoDetails> videoDetailsArrayList;
    LayoutInflater inflater;

    public MyCustomAdapter(Activity activity, ArrayList<VideoDetails> videoDetailsArrayList){
        this.activity = activity;
        this.videoDetailsArrayList = videoDetailsArrayList;
    }
    @Override
    public int getCount() {
        return this.videoDetailsArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return this.videoDetailsArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return (long)position;
    }

//    This method "populates" the listview using Adapter and pass the intent for video ID to the next activity so the video play is what user has clicked
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(inflater == null){
            inflater = this.activity.getLayoutInflater();
        }


        //      check if convertView is empty
        if(convertView == null){
            convertView = inflater.inflate(R.layout.custom, null);
        }

        ImageView imageView = (ImageView)convertView.findViewById(R.id.imageView);
        TextView textView = (TextView)convertView.findViewById(R.id.mytitle);
        LinearLayout linearLayout = (LinearLayout)convertView.findViewById(R.id.root);
        final VideoDetails videoDetails = (VideoDetails)this.videoDetailsArrayList.get(position);

        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent (activity,VideoPlayActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("videoId",videoDetails.getVideoID());
//                i.putExtra("videoId",videoDetails.getVideoID());
                activity.startActivity(i);

            }
        });


        //Load image and description to the individual listview items
        Picasso.get().load(videoDetails.getUrl()).into(imageView);
        textView.setText(videoDetails.getTitle());

        return convertView;
    }
}

