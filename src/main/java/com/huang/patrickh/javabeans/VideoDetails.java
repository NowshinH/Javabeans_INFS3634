package com.huang.patrickh.javabeans;


//Class to get and set video information

public class VideoDetails {

    /*This class contains all of the attributes for the videos in the OOP Playlist*/

    public String videoID, title, description, url;

    public VideoDetails(String videoID, String title, String description, String url) {
        this.videoID = videoID;
        this.title = title;
        this.description = description;
        this.url = url;
    }

    public VideoDetails(){}

    public String getVideoID() {
        return videoID;
    }

    public void setVideoID(String videoID) {
        this.videoID = videoID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


}
