package com.VideoRankingApplication.videos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Document(collection = "videos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VideoDocument {
    @Id
    private ObjectId objectId;
    @DocumentReference
    List<Video> Videos;
}
