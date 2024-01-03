package com.VideoRankingApplication.ui;

import com.VideoRankingApplication.videos.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.*;
import java.awt.event.ActionEvent;

@RestController
public class SubmitAction extends AbstractAction {
    private JTextField videoTitle;
    private JTextField imgUrl;
    @Autowired
    private VideoService videoService = new VideoService();
    public SubmitAction(JTextField videoTitle,JTextField imgUrl) {
        super("Submit");
        this.videoTitle = videoTitle;
        this.imgUrl = imgUrl;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
      //Video video = videoService.addNewVideo(videoTitle.getText(), imgUrl.getText());
    }
}
