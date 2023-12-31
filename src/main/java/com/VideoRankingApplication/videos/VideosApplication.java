package com.VideoRankingApplication.videos;

import com.VideoRankingApplication.persistence.JsonReader;
import com.VideoRankingApplication.persistence.JsonWriter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@SpringBootApplication
@RestController
public class VideosApplication {
    private static final String JSON_INFILE = "C:\\mongodb\\videos\\data/YTvideos.json";
    private static final String JSON_OUTFILE = "C:\\mongodb\\videos\\data/FormattedVideos.json";


	public static void main(String[] args) {
        try {
            initializeData();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        SpringApplication.run(VideosApplication.class, args);
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
    @GetMapping("/")
    public String apiRoot() {
        return "Hello World";
    }



}
