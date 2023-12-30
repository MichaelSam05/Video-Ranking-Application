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
        return new ResponseEntity<String>("videos stub", HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Video> addNewVideo(@RequestBody String title, String imgUrl){
        return new ResponseEntity<Video>(videoService.addNewVideo(title,imgUrl),HttpStatus.CREATED);
    }
}
