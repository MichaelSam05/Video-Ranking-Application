package com.VideoRankingApplication.videos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

//Represents a video service class that interacts with the database
@Service
public class VideoService {

    private VideoRankingSystem vrs = new VideoRankingSystem();

    @Autowired
    private VideoDocumentRepository videoDocumentRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public Video addNewVideo(String title, String imgUrl) {
        //Video video = videoRepo.insert(new Video(title,imgUrl,"n/a",0,"n/a"));
        Video video = new Video(title,imgUrl,"n/a",0,"n/a");
        mongoTemplate.update(VideoDocument.class)
                .apply(new Update().push("Videos").value(video)).first();
        vrs.addVideo(video);

        return video;

    }

    public List<Video> getAllVideos() {
        List<Video> videos = mongoTemplate.findAll(Video.class,"videos");
        return videos;
    }

    public Integer calcNewResuls(String winner,String losser) {
//        Criteria elementMatchCriteria = Criteria.where("videos.Videos").elemMatch(Criteria.where("Videos.VideoUrl").is(winner));
//        Query query = Query.query(elementMatchCriteria);
//        Video winnerKey =  mongoTemplate.findOne(query, Video.class);
//        elementMatchCriteria = Criteria.where("videos.Videos").elemMatch(Criteria.where("Videos.VideoUrl").is(losser));
//        query = Query.query(elementMatchCriteria);
//        Video loserKey = mongoTemplate.findOne(query, Video.class);



//        List<Video> videos = mongoTemplate.findAll(VideoDocument.class).get(0).Videos;
//        Video winner =videos.get(0);
//        Video losser = videos.get(0);
//        for (Video next: videos) {
//            if (next.getVideoID().equals(winnerKey)) {
//                 winner = next;
//            } else if (next.getVideoID().equals(losserKey)) {
//                 losser = next;
//            }
//        }
        Query query = new Query();
        query.addCriteria(Criteria.where("Videos").is(winner));
        List<Video> winnerKey = mongoTemplate.find(query,Video.class);


        return winnerKey.size();
    }

    public Video getChallenger() {
        return vrs.getChallenger();
    }

}
