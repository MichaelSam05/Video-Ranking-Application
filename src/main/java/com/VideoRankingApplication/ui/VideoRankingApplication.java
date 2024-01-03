package com.VideoRankingApplication.ui;

import javax.swing.*;
import java.awt.*;

public class VideoRankingApplication extends JFrame {


    private static final int FRAME_WIDTH = 1000;

    private static final int FRAME_HEIGHT = 700;

    private static final Color FRAME_COLOR = Color.darkGray;



    //EFFECTS: constructs the application GUI to be displayed to the user
    public VideoRankingApplication() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setLayout(null);
        setResizable(true);
        constructGUI();
        setVisible(true);
    }

    //MODIFIES: this
    //EFFECTS: establishes the layout of the GUI
    private void constructGUI() {
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(null);
        menuPanel.setBackground(FRAME_COLOR);
        menuPanel.setBounds(0, 0, 200, FRAME_HEIGHT);
        JLabel menuLabel = new JLabel("MAIN MENU");
        menuLabel.setForeground(Color.WHITE);
        menuLabel.setBounds(10, 10, 190, 40);
        menuPanel.add(menuLabel);

        JPanel displayPanel = initializePanel();
        createButtons(menuPanel, displayPanel);

        add(displayPanel);
        add(menuPanel);
    }

    //MODIFIES: this, menuPanel, displayPanel
    //EFFECTS: creates the button options available to the user
    private void createButtons(JPanel menuPanel, JPanel displayPanel) {
        JButton addButton = new JButton(new AddVideoAction(displayPanel));
        addButton.setBounds(10, 40, 180, 40);
        menuPanel.add(addButton);
//        JButton deleteButton = new JButton(new DeleteVideoAction());
//        deleteButton.setBounds(10, 90, 180, 40);
//        JButton listButton = new JButton(new ListVideosAction(displayPanel));
//        listButton.setBounds(10, 140, 180, 40);
        //JButton filterButton = new JButton(new FilterVideosAction(displayPanel));
        //filterButton.setBounds(10, 190, 180, 40);
        //JButton favButton = new JButton(new FavouriteVideoAction(state));
//        favButton.setBounds(10, 240, 180, 40);
//        JButton unfavButton = new JButton(new UnfavouriteVideoAction(state));
//        unfavButton.setBounds(10, 290, 180, 40);

//        addButtons(addButton, deleteButton, listButton, filterButton, favButton, unfavButton, saveButton,
//                loadButton, sortButton, menuPanel);
    }

    //MODIFIES: menuPanel
    //EFFECTS: adds the created buttons to the menuPanel
    private void addButtons(JButton addButton, JButton deleteButton, JButton listButton, JButton filterButton,
                            JButton favButton, JButton unfavButton, JButton saveButton, JButton loadButton, JButton sortButton,
                            JPanel menuPanel) {

        menuPanel.add(addButton);
        menuPanel.add(deleteButton);
        menuPanel.add(listButton);
        menuPanel.add(filterButton);
        menuPanel.add(sortButton);
        menuPanel.add(favButton);
        menuPanel.add(unfavButton);
        menuPanel.add(saveButton);
        menuPanel.add(loadButton);
    }

    //EFFECTS: initializes the displayPanel for displaying relevant output to the user
    private JPanel initializePanel() {
        JPanel displayPanel = new JPanel();
        displayPanel.setLayout(null);
        displayPanel.setBounds(200, 0, 800, FRAME_HEIGHT);
        displayPanel.setBackground(FRAME_COLOR);
        return displayPanel;

    }
}