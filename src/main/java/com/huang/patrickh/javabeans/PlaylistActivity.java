package com.huang.patrickh.javabeans;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class PlaylistActivity extends AppCompatActivity {

    String API_KEY = "IzaSyDCCOTP1yxGl7x8A3fr7djFp0hRbs2dFbg";
    String url = "https://www.googleapis.com/youtube/v3/search?part=snippet&channelId=UC19i1XD6k88KqHlET8atqFQ&maxResults=12&key=AIzaSyDCCOTP1yxGl7x8A3fr7djFp0hRbs2dFbg";

    ListView listView;
    ArrayList<VideoDetails> videoDetailsArrayList;
    MyCustomAdapter myCustomAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist);

        listView = findViewById(R.id.listView);

        videoDetailsArrayList = new ArrayList<>();

        myCustomAdapter = new MyCustomAdapter(PlaylistActivity.this, videoDetailsArrayList);

        displayVideo();
    }

//    The actual method that displays the list of videos from JSON file gathered from the google API URL
//    Information gathered are the Image(preview) of the video, video ID (strings that identifies the video), the title and the description
    private void displayVideo() {
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("items");

//                    Adding "videos" to the list (in the form of array)
                    for(int i = 0; i<jsonArray.length();i++){
                        JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                        JSONObject jsonVideoId = jsonObject1.getJSONObject("id");
                        JSONObject jsonObjectSnippet = jsonObject1.getJSONObject("snippet");
                        JSONObject jsonObjectDefault = jsonObjectSnippet.getJSONObject("thumbnails").getJSONObject("medium");

                        String video_id = jsonVideoId.getString("videoId");
                        VideoDetails vd = new VideoDetails();

                        vd.setVideoID(video_id);
                        vd.setTitle(jsonObjectSnippet.getString("title"));
                        vd.setDescription(jsonObjectSnippet.getString("description"));
                        vd.setUrl(jsonObjectDefault.getString("url"));

                        videoDetailsArrayList.add(vd);
                    }

                    listView.setAdapter(myCustomAdapter);
                    myCustomAdapter.notifyDataSetChanged();


                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        requestQueue.add(stringRequest);

    }


}

