package com.MoneyTrackz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TitleScreen {
    public JPanel titlePanel;
    private JLabel welcomeLabel;
    private JTextArea titleTextArea;
    private JScrollPane titleScrollPane;
    private JButton startButton, lightModeButton;
    public static JFrame mainFrame = new JFrame("<Money Tracker>");
    public static Color customColor = new Color(0, 0, 150);
    public static int i = 1;

    //Sets LightMode
    public void lightMode(){
        if(i % 2 == 0) {
            brightMode();
        }else{
            darkMode();
        }
    }

    //Sets The Brighter Version Of The TitleScreen
    public void brightMode(){
        titlePanel.setBackground(Color.white);
        welcomeLabel.setBackground(Color.white);
        welcomeLabel.setForeground(Color.black);
        titleTextArea.setBackground(Color.white);
        titleTextArea.setForeground(Color.black);
        titleScrollPane.setBackground(Color.white);
        titleScrollPane.setForeground(Color.black);
        startButton.setBackground(Color.white);
        startButton.setForeground(Color.black);
        lightModeButton.setBackground(Color.white);
        lightModeButton.setForeground(Color.black);
    }

    //Sets The Darker Version Of The Title Screen
    public void darkMode(){
        titlePanel.setBackground(Color.black);
        welcomeLabel.setBackground(Color.black);
        welcomeLabel.setForeground(customColor);
        titleTextArea.setBackground(Color.black);
        titleTextArea.setForeground(customColor);
        titleScrollPane.setBackground(Color.black);
        titleScrollPane.setForeground(customColor);
        startButton.setBackground(Color.black);
        startButton.setForeground(customColor);
        lightModeButton.setBackground(Color.black);
        lightModeButton.setForeground(customColor);
    }

    public TitleScreen() {
        lightMode();

        //Goes To HelpScreen and Closes TitleScreen
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.setContentPane(new HelpScreen().helpPanel);
                mainFrame.setSize(500, 500);
                mainFrame.setLocationRelativeTo(null);
                mainFrame.setResizable(false);
                mainFrame.setVisible(true);
                mainFrame.setIconImage(new ImageIcon("icon.png").getImage());
            }
        });
        lightModeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                i++;
               lightMode();
            }
        });
    }

    public static void main(String[] args){
        //Creates The Window For The Start Screen Which Is Linked To The Help Screen
        mainFrame.setSize(500,500);
        mainFrame.setContentPane(new TitleScreen().titlePanel);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setResizable(false);
        mainFrame.setVisible(true);
        mainFrame.setIconImage(new ImageIcon("icon.png").getImage());
    }
}
