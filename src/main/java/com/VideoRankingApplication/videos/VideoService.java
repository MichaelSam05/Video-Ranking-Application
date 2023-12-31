package com.VideoRankingApplication.videos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoService {

    private VideoRankingSystem vrs = new VideoRankingSystem();

    @Autowired
    private VideoRepository videoRepo;

    @Autowired
    private MongoTemplate mongoTemplate;

    public Video addNewVideo(String title, String imgUrl) {
        Video video = videoRepo.insert(new Video(title,imgUrl,"n/a",0,"n/a"));
        mongoTemplate.update(Video.class)
                .apply(new Update().push("Videos").value(video)).first();
        vrs.addVideo(video);

        return video;

    }

    public List<Video> getAllVideos() {
        return videoRepo.findAll();
    }
}
