package com.VideoRankingApplication.videos;

import org.bson.types.ObjectId;
import org.json.JSONObject;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "videos")
public class Video {
    @Id
    private ObjectId objectId;

    private String VideoTitle;

    private String Thumbnail;

    private String UploadDate;

    private int Views;

    private String VideoID;

    private boolean isFavourite;

    private int elo;
    private static final int ELO = 1600;

    public Video(String VideoTitle, String Thumbnail, String UploadDate, int Views, String VideoID) {
        this.VideoTitle = VideoTitle;
        this.Thumbnail = Thumbnail;
        this.UploadDate = UploadDate;
        this.Views = Views;
        this.VideoID = VideoID;
        isFavourite = false;
        initElo(Views);
    }

    public String getThumbnail() {
        return Thumbnail;
    }

    public int getElo() {
        return elo;
    }

    public String getUploadDate() {
        return UploadDate;
    }

     public String getVideoID() {
        return VideoID;
     }

    public String getVideoTitle() {
        return VideoTitle;
    }

    public int getViews() {
        return Views;
    }

    //EFFECTS: initializes the elo for videos that came from the YouTube api
    public void initElo(int numViews) {
        int result =  ELO + (numViews/10000);//create an elo using numViews param
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


    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("VideoTitle", VideoTitle);
        json.put("Thumbnail", Thumbnail);
        json.put("UploadDate",  UploadDate);
        json.put("Views", Views);
        json.put("Elo-Rank",elo);
        json.put("IsFavourite", isFavourite);
        json.put("VideoUrl",VideoID);
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
        return (video.getVideoID().equals(this.VideoID));
    }


}
