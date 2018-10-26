package com.huang.patrickh.javabeans;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

//Activity that play the youtube video
public class VideoPlayActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener{

    YouTubePlayerView playerView;
    String VIDEO_ID = "goaZTAzsLMk";

    static final String API_KEY = "AIzaSyDCCOTP1yxGl7x8A3fr7djFp0hRbs2dFbg";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_play);
        playerView = (YouTubePlayerView)findViewById(R.id.playerView);
        playerView.initialize(API_KEY,this);


    }

    //Plays video
    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player, boolean b) {



        if(!b){
            player.cueVideo(VIDEO_ID);
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult result) {

    }


}
