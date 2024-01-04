package com.VideoRankingApplication.videos;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.Math.abs;
import static java.lang.Math.pow;


public class VideoRankingSystem {
    private List<Video> videos;
    public VideoRankingSystem() {
        videos = new ArrayList<>();
    }

    public List<Video> getVideos() {
        return videos;
    }

    public void addVideo(Video video) {
        videos.add(video);
    }

    public void deleteVideo(Video video) {
        videos.remove(video);
    }

    //REQUIRES: the winning video be the first parameter and the losing video be the second parameter
    //MODIFIES: Video
    //EFFECTS: calculates the new elo for both videos after the user makes their selection
    public int calcElo(Video winner,Video losser) {
        float result = (abs(winner.getElo() - losser.getElo()))/400;
         result = (float) (1 + pow(10,result));
         result = 20 * (1 - (1/result));

         winner.setElo((int) (winner.getElo() + result));
         losser.setElo((int) (losser.getElo() - result));

         return (int) result;
    }

    //EFFECTS: finds a random video in the list of videos to participate in the rank match
    public Video getChallenger(List<Video> vidsDb) {
        Random rand = new Random();
        int index = rand.nextInt(vidsDb.size());
        return vidsDb.get(index);
    }

    //REQUIRES: a randomly selected video to be the challenger
    //EFFECTS: returns an opponent of similar rating/elo
    public Video getOpponent(Video challenger,List<Video> vidsDb) {
        Video opponent = vidsDb.get(0);
        int lowestElo = abs(opponent.getElo() - challenger.getElo());
        int eloDiff;
        for (Video next : vidsDb) {
            eloDiff = abs(next.getElo() - challenger.getElo());
            if (eloDiff < lowestElo ) {
                lowestElo = eloDiff;
                opponent = next;
            }
        }
        return opponent;
    }


    // EFFECTS: returns the songs in this songDatabase as a JSON array
    public JSONArray videosToJson() {
        JSONArray jsonArray = new JSONArray();
        for (Video next : videos) {
            jsonArray.put(next.toJson());
        }
        return jsonArray;
    }
}
