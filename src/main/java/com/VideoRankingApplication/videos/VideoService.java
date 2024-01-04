package com.VideoRankingApplication.videos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

//Represents a video service class that interacts with the database
@Service
public class VideoService {

    private VideoRankingSystem vrs = new VideoRankingSystem();

    @Autowired
    private VideoRepository videoRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public Video addNewVideo(String title, String imgUrl) {
        Video video = videoRepository.insert(new Video(title,imgUrl,"n/a",0,"n/a"));
//        mongoTemplate.update(Video.class)
//                .apply(new Update().push("Videos").value(video)).first();
//        vrs.addVideo(video);

        return video;

    }

    public List<Video> getAllVideos() {
        return videoRepository.findAll();
    }

    public Video calcNewResuls(String winner,String losser) {

        Query query = new Query();
        query.addCriteria(Criteria.where("Thumbnail").is(winner));
        List<Video> winnerKey = mongoTemplate.find(query,Video.class);
        Query query1 = new Query();
        query1.addCriteria(Criteria.where("Thumbnail").is(losser));
        List<Video> losserKey = mongoTemplate.find(query1,Video.class);

        int result = vrs.calcElo(winnerKey.get(0),losserKey.get(0));

        videoRepository.save(winnerKey.get(0));
        videoRepository.save(losserKey.get(0));

        return winnerKey.get(0);//temp return type
    }

    public Video getChallenger() {
        return vrs.getChallenger(videoRepository.findAll());
    }

    public Video getOppponent(Video challenger) {
        Query query = new Query();
        query.addCriteria(Criteria.where("Thumbnail").ne(challenger.getThumbnail()));
        List<Video> videos = mongoTemplate.find(query,Video.class);
        return vrs.getOpponent(challenger,videos);

    }

}
