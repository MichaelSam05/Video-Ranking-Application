package com.VideoRankingApplication.persistence;

import com.VideoRankingApplication.videos.Video;
import com.VideoRankingApplication.videos.VideoRankingSystem;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

//"Code influenced by the JsonSerizalizationDemo https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git"
// Represents a reader that reads videoDatabase from JSON data stored in file
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads videoDatabase from file and returns it;
    // throws IOException if an error occurs reading data from file
    public VideoRankingSystem read() throws IOException {
        String jsonData = readFile(source);
        JSONArray jsonArray = new JSONArray(jsonData);
        return parseVideoDatabase(jsonArray);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses videoDatabase from JSON object and returns it
    private VideoRankingSystem parseVideoDatabase(JSONArray jsonArray) {
        VideoRankingSystem  vrs = new VideoRankingSystem();
        addVideos(vrs, jsonArray);
        return vrs;
    }

    // MODIFIES: vd
    // EFFECTS: parses videos from JSON object and adds them to videoDatabase
    private void addVideos(VideoRankingSystem vrs, JSONArray jsonArray) {

        for (Object json : jsonArray) {
            JSONObject nextVideo = (JSONObject) json;
            addVideo(vrs, nextVideo);
        }
    }

    // MODIFIES: vd
    // EFFECTS: parses video from JSON object and adds it to videoDatabase
    private void addVideo(VideoRankingSystem vrs, JSONObject jsonObject) {
        String title = jsonObject.getString("VideoTitle");
        String thumbnail = jsonObject.getString("Thumbnail");
        String uploadDate = jsonObject.getString("UploadDate");
        int views = jsonObject.getInt("Views");
        String videoID = jsonObject.getString("VideoID");

        Video video = new Video(title, thumbnail, uploadDate, views, videoID);
        vrs.addVideo(video);
    }
}



