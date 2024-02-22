package com.VideoRankingApplication.videos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//Personal notes: represents the REST API for the front end
@CrossOrigin("*")
@RestController
@RequestMapping("/api/videos")//this http request is possibly temporary
public class VideoController {

    @Autowired
    private VideoService videoService;

    //Rest API that gets all the videos in the database
    @GetMapping
    public ResponseEntity<List<Video>> getVideos() {
        return new ResponseEntity<List<Video>>(videoService.getAllVideos(), HttpStatus.OK);
    }

    //Rest API that adds a new video to the database
    @PostMapping
    public ResponseEntity<Video> addNewVideo(@RequestBody Map<String,String> payload){
        return new ResponseEntity<Video>(videoService.addNewVideo(payload.get("videoTitle"),payload.get("videoThumbnail")),HttpStatus.CREATED);
    }

    //Rest API that sets up the match
    @GetMapping("/rank")
    public ResponseEntity<List<Video>> setupMatch() {
        Video challenger = videoService.getChallenger();
        Video opponent = videoService.getOppponent(challenger);
        List<Video> match = new ArrayList<>();
        match.add(challenger);
        match.add(opponent);
        return new ResponseEntity<List<Video>>(match,HttpStatus.OK);
    }


    //Rest API that updates the elo for each video after a match
    @PutMapping //temp return type
    public ResponseEntity<Video> updateElos(@RequestBody Map<String,String> payload) {
        return new ResponseEntity<Video>(videoService.calcNewResuls(payload.get("winner"),payload.get("losser")), HttpStatus.OK);
    }

    //EFFECTS: rest API for deleting videos
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteVideo(@PathVariable("id") int id) {
          return new ResponseEntity<String>(videoService.deleteVideo(id),HttpStatus.OK);

    }

}
