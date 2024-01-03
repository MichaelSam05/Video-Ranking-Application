package com.VideoRankingApplication.ui;

import com.VideoRankingApplication.persistence.JsonReader;
import com.VideoRankingApplication.persistence.JsonWriter;
import com.VideoRankingApplication.videos.VideoRankingSystem;

import java.io.IOException;


public class Main {
    private static final String JSON_INFILE = "C:\\mongodb\\videos\\data/YTvideos.json";
    private static final String JSON_OUTFILE = "C:\\mongodb\\videos\\data/FormattedVideos.json";


	public static void main(String[] args) {
        try {
            initializeData();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        new VideoRankingApplication();
	}

    private static void initializeData() throws IOException {
        VideoRankingSystem vrs = new VideoRankingSystem();
        JsonReader jsonReader = new JsonReader(JSON_INFILE);
        JsonWriter jsonWriter = new JsonWriter(JSON_OUTFILE);
        vrs = jsonReader.read();
        jsonWriter.open();
        jsonWriter.write(vrs);
        jsonWriter.close();
    }



}
