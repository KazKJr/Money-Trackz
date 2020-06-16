package com.MoneyTrackz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HelpScreen{
    public JPanel helpPanel;
    private JLabel helpLabel;
    private JTextArea helpTextArea;
    private JScrollPane helpScrollPane;
    public static JFrame mainFrame = new JFrame("<Money Tracker>");

    //Sets The Brighter Version Of The Help Screen
    public void brightMode(){
        helpPanel.setBackground(Color.white);
        helpLabel.setBackground(Color.white);
        helpLabel.setForeground(Color.black);
        helpTextArea.setBackground(Color.white);
        helpTextArea.setForeground(Color.black);
    }
    //Sets The Darker Version Of The Help Screen
    public void darkMode(){
        helpPanel.setBackground(Color.black);
        helpLabel.setBackground(Color.black);
        helpLabel.setForeground(TitleScreen.customColor);
        helpTextArea.setBackground(Color.black);
        helpTextArea.setForeground(TitleScreen.customColor);
    }

    public HelpScreen() {
        //Sets LightMode on Start Up Of Screen
        if(TitleScreen.i % 2 == 0) {
            brightMode();
        }else{
            darkMode();
        }
        //Closes Windows
        helpTextArea.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if(e.getKeyCode() == KeyEvent.VK_X){
                    WindowEvent closeMS = new WindowEvent(MainScreen.mainFrame, WindowEvent.WINDOW_CLOSING);
                    WindowEvent closeTS = new WindowEvent(TitleScreen.mainFrame, WindowEvent.WINDOW_CLOSING);
                    Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeMS);
                    Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeTS);
                    mainFrame.setContentPane(new MainScreen().mainPanel);
                    mainFrame.setSize(500, 500);
                    mainFrame.setLocationRelativeTo(null);
                    mainFrame.setResizable(false);
                    mainFrame.setVisible(true);
                    mainFrame.setIconImage(new ImageIcon("icon.png").getImage());
                }
            }
        });
    }
}
