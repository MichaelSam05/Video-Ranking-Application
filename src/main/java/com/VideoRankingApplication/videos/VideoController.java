package com.VideoRankingApplication.videos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/next")//this http request ("/next") is temporary
public class VideoController {

    @Autowired
    private VideoService videoService;

    @GetMapping
    public ResponseEntity<String> getVideos() {
        return new ResponseEntity<String>("all videos stub", HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Video> addNewVideo(@RequestBody String VideoTitle, String Thumbnail){
        return new ResponseEntity<Video>(videoService.addNewVideo(VideoTitle,Thumbnail),HttpStatus.CREATED);
    }
}
