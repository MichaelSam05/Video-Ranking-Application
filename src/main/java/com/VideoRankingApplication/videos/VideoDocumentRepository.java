package com.VideoRankingApplication.videos;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoDocumentRepository extends MongoRepository<VideoDocument, ObjectId> {
}
