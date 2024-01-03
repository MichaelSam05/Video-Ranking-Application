package com.VideoRankingApplication.videos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

//Personal notes: represents the REST API for the front end
@RestController
@RequestMapping("/next")//this http request is possibly temporary
public class VideoController {

    @Autowired
    private VideoService videoService;

    //Rest API that gets all the videos in the database
    @GetMapping
    public ResponseEntity<String> getVideos() {
        return new ResponseEntity<String>("videos", HttpStatus.OK);
    }

    //Rest API that adds a new video to the database
    @PostMapping //this is a POST request and is used in conjunction with POSTMAN to test http requests
    public ResponseEntity<Video> addNewVideo(@RequestBody Map<String,String> payload){
        return new ResponseEntity<Video>(videoService.addNewVideo(payload.get("VideoTitle"),payload.get("Thumbnail")),HttpStatus.CREATED);
    }

//    @GetMapping
//    public ResponseEntity<Video> getOpponent() {
//        return new ResponseEntity<Video>(videoService.)
//    }


    //Rest API that updates the elo for each video after a match
    @PutMapping //
    public ResponseEntity<Integer> updateElos(@RequestBody Map<String,String> payload) {
        return new ResponseEntity<Integer>(videoService.calcNewResuls(payload.get("winner"),payload.get("loser")), HttpStatus.OK);
    }


}
