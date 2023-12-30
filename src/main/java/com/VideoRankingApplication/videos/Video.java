package com.VideoRankingApplication.videos;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "videos")
public class Video {

    @Id
    private String title;
    private String uploadDate;
    private int numLikes;
    private int numViews;
    private String url;
    private boolean isFavourite;
    private int elo;
    private String imgUrl;

    public Video(String title, String imgUrl) {
        this.title = title;
        this.imgUrl = imgUrl;
        isFavourite = false;
        elo = 1600;
    }

    public String getImgUrl() {
        return imgUrl;
    }
    //EFFECTS: initializes the elo for videos that came from the YouTube api
    public void initElo(int numViews) {
        int result = elo + (numViews/10000);//create an elo using numViews param
        this.elo = result;
    }

    public String getTitle() {
        return title;
    }

    public String getUploadDate() {
        return uploadDate;
    }

    public int getViews() {
        return numViews;
    }

    public int getLikes() {
        return numLikes;
    }

    public String getUrl() {
        return url;
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

    public int getElo() {
        return elo;
    }

    public void setElo(int elo) {
        this.elo = elo;
    }
}
