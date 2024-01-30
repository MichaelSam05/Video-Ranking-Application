package com.VideoRankingApplication.videos;

import org.bson.types.ObjectId;
import org.json.JSONObject;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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

    public Video(String VideoTitle, String Thumbnail, String UploadDate, int Views, String VideoUrl) {

        this.videoTitle = VideoTitle;
        this.thumbnail = Thumbnail;
        this.uploadDate = UploadDate;
        this.views = Views;
        this.videoUrl = VideoUrl;
        isFavourite = false;
        initElo(Views);
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

    @Override
    public boolean equals(Object obj)
    {
        // if both the object references are
        // referring to the same object.
        if(this == obj)
            return true;

        // it checks if the argument is of the
        // type Geek by comparing the classes
        // of the passed argument and this object.
        // if(!(obj instanceof Geek)) return false; ---> avoid.
        if(obj == null || obj.getClass()!= this.getClass())
            return false;

        // type casting of the argument.
        Video video = (Video) obj;

        // comparing the state of argument with
        // the state of 'this' Object.
        return (video.getVideoUrl().equals(this.videoUrl));
    }


}
