package com.VideoRankingApplication.ui;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class AddVideoAction extends AbstractAction {
    private JPanel displayPanel;
    public AddVideoAction(JPanel displayPanel) {
        super("Add New Video");
        this.displayPanel = displayPanel;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        displayPanel.removeAll();
        JTextField videoTitle = new JTextField();
        videoTitle.setBounds(50,45,250,30);
        JTextField imgUrl = new JTextField();
        imgUrl.setBounds(50,100,250,30);
        JButton submitButton = new JButton(new SubmitAction(videoTitle,imgUrl));
        submitButton.setBounds(50, 140, 100, 30);
        displayPanel.add(videoTitle);
        displayPanel.add(imgUrl);
        displayPanel.add(submitButton);
        displayPanel.repaint();

    }
}
