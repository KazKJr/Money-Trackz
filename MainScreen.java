package com.MoneyTrackz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

//Extends Transaction As The Methods From Transaction Are Used Here
public class MainScreen extends Transaction{
    public JPanel mainPanel;
    private JPanel reportPanel;
    private JLabel dateLabel, initialBalanceLabel,  moneySpentOrGainedLabel, balanceLabel;
    private JTextField initialBalanceTextField, moneySpentOrGainedTextField, balanceTextField;
    private JButton spentButton, gainedButton, reportButton, lightModeButton, helpScreenButton;
    private JTextArea reportTextArea;
    public static JFrame mainFrame = new JFrame("<Money Tracker>");

    //Sets The LightMode Of The Screen
    public void lightMode(){
        if(TitleScreen.i % 2 == 0) {
            brightMode();
        }else{
            darkMode();
        }
    }

    //Sets The Brighter Version Of The MainScreen
    public void brightMode(){
        mainPanel.setBackground(Color.white);
        dateLabel.setBackground(Color.white);
        dateLabel.setForeground(Color.black);
        initialBalanceLabel.setBackground(Color.white);
        initialBalanceLabel.setForeground(Color.black);
        initialBalanceTextField.setBackground(Color.white);
        initialBalanceTextField.setForeground(Color.black);
        moneySpentOrGainedLabel.setBackground(Color.white);
        moneySpentOrGainedLabel.setForeground(Color.black);
        moneySpentOrGainedTextField.setBackground(Color.white);
        moneySpentOrGainedTextField.setForeground(Color.black);
        balanceLabel.setBackground(Color.white);
        balanceLabel.setForeground(Color.black);
        balanceTextField.setBackground(Color.white);
        balanceTextField.setForeground(Color.black);
        reportTextArea.setBackground(Color.white);
        reportTextArea.setForeground(Color.black);
        reportButton.setBackground(Color.white);
        reportButton.setForeground(Color.black);
        lightModeButton.setBackground(Color.white);
        lightModeButton.setForeground(Color.black);
        helpScreenButton.setBackground(Color.white);
        helpScreenButton.setForeground(Color.black);
        spentButton.setBackground(Color.white);
        spentButton.setForeground(Color.black);
        gainedButton.setBackground(Color.white);
        gainedButton.setForeground(Color.black);
    }

    //Sets The Darker Version Of The MainScreen
    public void darkMode(){
        mainPanel.setBackground(Color.black);
        dateLabel.setBackground(Color.black);
        dateLabel.setForeground(TitleScreen.customColor);
        initialBalanceLabel.setBackground(Color.black);
        initialBalanceLabel.setForeground(TitleScreen.customColor);
        initialBalanceTextField.setBackground(Color.black);
        initialBalanceTextField.setForeground(TitleScreen.customColor);
        moneySpentOrGainedLabel.setBackground(Color.black);
        moneySpentOrGainedLabel.setForeground(TitleScreen.customColor);
        moneySpentOrGainedTextField.setBackground(Color.black);
        moneySpentOrGainedTextField.setForeground(TitleScreen.customColor);
        balanceLabel.setBackground(Color.black);
        balanceLabel.setForeground(TitleScreen.customColor);
        balanceTextField.setBackground(Color.black);
        balanceTextField.setForeground(TitleScreen.customColor);
        reportTextArea.setBackground(Color.black);
        reportTextArea.setForeground(TitleScreen.customColor);
        reportButton.setBackground(Color.black);
        reportButton.setForeground(TitleScreen.customColor);
        lightModeButton.setBackground(Color.black);
        lightModeButton.setForeground(TitleScreen.customColor);
        helpScreenButton.setBackground(Color.black);
        helpScreenButton.setForeground(TitleScreen.customColor);
        spentButton.setBackground(Color.black);
        spentButton.setForeground(TitleScreen.customColor);
        gainedButton.setBackground(Color.black);
        gainedButton.setForeground(TitleScreen.customColor);
    }

    //Sets The Balance To Be The Same As The Initial Balance
    public void setBalance() {
        if(getTransaction() < 1){
            String initialBalanceStr = initialBalanceTextField.getText();
            setInitialBalance(Double.parseDouble(initialBalanceStr));
            setBalance(Double.parseDouble(initialBalanceStr));
        }
    }

    //Calculates The Money Spent, Total Money Spent and Losses and Total Loss If Made For Each Transaction
    public void calculateMoneySpent(){
        String moneySpentOrGainedStr = moneySpentOrGainedTextField.getText();
        setMoneySpent(Double.parseDouble(moneySpentOrGainedStr));
        calculateBalanceSpent();
        calculateTotalMoneySpent();
        calculateLoss();
        calculateTotalMoneyLost();
        calculateSaving();
    }

    //Calculates The Money Gained, Total Money Gained and Money Saved For Each Transaction
    public void calculateMoneyGained(){
        String moneySpentOrGainedStr = moneySpentOrGainedTextField.getText();
        setGain(Double.parseDouble(moneySpentOrGainedStr));
        calculateBalanceGained();
        calculateTotalMoneyGained();
        calculateSaving();
    }

    //Sets The Balance After Each Transaction
    public void setFinalBalance(){
        balanceTextField.setText(String.format("%.2f", getBalance()));
        initialBalanceTextField.setText(String.format("%.2f", getInitialBalance()));
        initialBalanceTextField.setEditable(false);
        moneySpentOrGainedTextField.setText(null);
    }

    //Prints A Report After Each Transaction For The User To See
    public void printReport(){
        increaseTransaction();
        reportTextArea.setText(String.format("Report\n" + "Transaction: %d\nInitial Balance: $%.2f\nMoney Spent: $%.2f\nMoney Gained: $%.2f\nSaved: $%.2f\nLost: $%.2f\n", getTransaction(), getInitialBalance(), getMoneySpent(), getGain(), getSaving(), getLoss()));
    }

    //Writes The Final Report To Report.txt As Well As Opens It
    public void fileProcessor(){
        try {
            reportFileWriter();
            reportFileOpen();
        } catch (IOException ex) {
             ex.printStackTrace();
        }
    }
    //Closes The Window
    public void windowClosing(){
        WindowEvent closeHS = new WindowEvent(HelpScreen.mainFrame, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeHS);
    }

    public MainScreen() {
        //Sets The Title Of The Screen To Be The Date
        dateLabel.setText(dateStr);

        //In Case The User Was On The Help Screen This Ensures The Previous Work Done Is Continued
        if(getTransaction() >= 1){
            balanceTextField.setText(String.format("%.2f", getBalance()));
            initialBalanceTextField.setText(String.format("%.2f", getInitialBalance()));
            initialBalanceTextField.setEditable(false);
        }

        lightMode();

        //Set Shortcuts To Buttons
        spentButton.setMnemonic(KeyEvent.VK_S);
        gainedButton.setMnemonic(KeyEvent.VK_G);
        reportButton.setMnemonic(KeyEvent.VK_R);
        lightModeButton.setMnemonic(KeyEvent.VK_L);
        helpScreenButton.setMnemonic(KeyEvent.VK_H);

        //Controls The Functions Of The Spent Button
        spentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setBalance();
                calculateMoneySpent();
                setFinalBalance();
                printReport();
            }
        });
        //Controls The Functions Of The Gained Button
        gainedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setBalance();
                calculateMoneyGained();
                setFinalBalance();
                printReport();
            }
        });
        //Controls The Functions Of The Report Button
        reportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               fileProcessor();
            }
        });
        //Goes To HelpScreen
        helpScreenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                windowClosing();
                mainFrame.setContentPane(new HelpScreen().helpPanel);
                mainFrame.setSize(500, 500);
                mainFrame.setLocationRelativeTo(null);
                mainFrame.setResizable(false);
                mainFrame.setVisible(true);
                mainFrame.setIconImage(new ImageIcon("icon.png").getImage());
            }
        });
        //Changes Light Mode From Darker To Brighter Or Vice Versa
        lightModeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TitleScreen.i++;
                lightMode();
            }
        });
    }
}
