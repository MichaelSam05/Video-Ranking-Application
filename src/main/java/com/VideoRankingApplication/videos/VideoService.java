package com.VideoRankingApplication.videos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoService {

    private VideoRankingSystem vrs = new VideoRankingSystem();

    @Autowired
    private VideoRepository videoRepo;

    public Video addNewVideo(String title, String imgUrl) {
        Video video = new Video(title,imgUrl);
        videoRepo.insert(video);
        vrs.addVideo(video);

        return video;

    }

    public List<Video> getAllVideos() {
        return videoRepo.findAll();
    }
}
