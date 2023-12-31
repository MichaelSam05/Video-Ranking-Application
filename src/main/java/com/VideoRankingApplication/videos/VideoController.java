package com.VideoRankingApplication.videos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/next")//this http request ("/next") is temporary
public class VideoController {

    @Autowired
    private VideoService videoService;

    @GetMapping
    public ResponseEntity<String> getVideos() {
        return new ResponseEntity<String>("videos stub", HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Video> addNewVideo(@RequestBody Map<String,String> payload){
        return new ResponseEntity<Video>(videoService.addNewVideo(payload.get("VideoTitle"),payload.get("Thumbnail")),HttpStatus.CREATED);
    }
}
