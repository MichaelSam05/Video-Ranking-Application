package com.VideoRankingApplication.videos;

import org.bson.types.ObjectId;
import org.json.JSONObject;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// represents a video for a database in a video ranking sytem
@Document(collection = "videos")
public class Video {
    @Id
    private ObjectId objectId;

    static int temp= 0;
    int id = temp;
    private String videoTitle;

    private String thumbnail;

    private String uploadDate;

    private int views;

    private String videoUrl;

    private boolean isFavourite;

    private int elo;

    public Video(String videoTitle, String thumbnail, String uploadDate, int views, String videoUrl) {

        this.videoTitle = videoTitle;
        this.thumbnail = thumbnail;
        this.uploadDate = uploadDate;
        this.views = views;
        this.videoUrl = videoUrl;
        isFavourite = false;
        initElo(views);
        id++;
        temp = id;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public int getElo() {
        return elo;
    }

    public String getUploadDate() {
        return uploadDate;
    }

     public String getVideoUrl() {return videoUrl;}

    public String getVideoTitle() {
        return videoTitle;
    }

    public int getViews() {
        return views;
    }

    //EFFECTS: initializes the elo for videos that came from the YouTube api
    public void initElo(int numViews) {
        int result =  1600 + (numViews/10000);//create an elo using numViews param
        this.elo = result;
    }


    public boolean getFavourite() {
        return isFavourite;
    }

    public void setFavourite() {
        this.isFavourite = true;
    }

    public void resetFavourite() {
        this.isFavourite = false;
    }

    public void setElo(int elo) {
        this.elo = elo;
    }

    public int getId() {
        return id;
    }


    //EFFECTS: converts a video object into a json object
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("videoTitle", videoTitle);
        json.put("thumbnail", thumbnail);
        json.put("uploadDate", uploadDate);
        json.put("views", views);
        json.put("elo-Rank",elo);
        json.put("isFavourite", isFavourite);
        json.put("videoUrl", videoUrl);
        json.put("id",id);
        return json;
    }
}
