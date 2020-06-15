package com.MoneyTrackz;

import java.text.*;
import java.util.*;
import java.io.*;
import java.awt.*;

public class Transaction {
    private static double initialBalance, moneySpent, totalMoneySpent, balance, saving, loss, totalLoss, gain, totalGain;//These Are Static Because Main and BrightMain Screens Data Did Not Save Unless They Were Static
    private static int transaction;
    private DateFormat dateFormat = new SimpleDateFormat("E dd MMM yyyy");
    private Date date = new Date();
    private File reportFile = new File("Report.txt");
    public String dateStr = dateFormat.format(date);

    //Blank Constructor
    public Transaction() {
    }

    //Constructor Containing All The Variables Except The File and Date Variables
    public Transaction(double initialBalance, double moneySpent, double totalMoneySpent, double balance, double saving, double loss, double totalLoss, double gain, double totalGain, int transaction) {
        Transaction.initialBalance = initialBalance;
        Transaction.moneySpent = moneySpent;
        Transaction.totalMoneySpent = totalMoneySpent;
        Transaction.balance = balance;
        Transaction.saving = saving;
        Transaction.loss = loss;
        Transaction.totalLoss = totalLoss;
        Transaction.gain = gain;
        Transaction.totalGain = totalGain;
        Transaction.transaction = transaction;
    }

    //Getter And Setters For The Variables
    public double getInitialBalance() {
        return initialBalance;
    }

    public void setInitialBalance(double initialBalance) {
        Transaction.initialBalance = initialBalance;
    }

    public double getMoneySpent() {
        return moneySpent;
    }

    public void setMoneySpent(double moneySpent) {
        Transaction.moneySpent = moneySpent;
    }

    public double getTotalMoneySpent() {
        return totalMoneySpent;
    }

    public void setTotalMoneySpent(double totalMoneySpent) {
        Transaction.totalMoneySpent = totalMoneySpent;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        Transaction.balance = balance;
    }

    public double getSaving() {
        return saving;
    }

    public void setSaving(double saving) {
        Transaction.saving = saving;
    }


    public double getLoss() {
        return loss;
    }

    public void setLoss(double loss) {
        Transaction.loss = loss;
    }

    public double getTotalLoss() {
        return totalLoss;
    }

    public void setTotalLoss(double totalLoss) {
        Transaction.totalLoss = totalLoss;
    }

    public double getGain() {
        return gain;
    }

    public void setGain(double gain) {
        Transaction.gain = gain;
    }

    public double getTotalGain() {
        return totalGain;
    }

    public void setTotalGain(double totalGain) {
        Transaction.totalGain = totalGain;
    }

    public int getTransaction() {
        return transaction;
    }

    public void setTransaction(int transaction) {
        Transaction.transaction = transaction;
    }

    //Calculates The Amount Of Money Spent After Each Transaction Where Money Was Spent
    public void calculateBalanceSpent(){
        Transaction.balance -= Transaction.moneySpent;
    }

    //Calculates The Amount Of Money Gained After Each Transaction Where Money Was Gained
    public void calculateBalanceGained(){
        Transaction.balance += Transaction.gain;
    }

    //Calculates The Total Amount Of Money Spent After Each Transaction Where Money Was Spent
    public void calculateTotalMoneySpent(){
        Transaction.totalMoneySpent += Transaction.moneySpent;
    }

    //Calculates The Total Amount Of Money Gained After Each Transaction Where Money Was Gained
    public void calculateTotalMoneyGained(){
        Transaction.totalGain += Transaction.gain;
    }

    //Calculates The Total Amount Of Money Lost
    public void calculateTotalMoneyLost(){
        Transaction.totalLoss -= Transaction.loss;
    }

    //Calculates How Much Money One Saved After Each Transaction
    public void calculateSaving(){
        if(Transaction.balance < Transaction.initialBalance && Transaction.balance > 0){
            Transaction.saving = Transaction.balance;
        } else{
            Transaction.saving = 0;
        }
    }

    //Calculates How Much Money One Lost After Each Transaction
    public void calculateLoss(){
        if(Transaction.balance < 0){
            Transaction.loss = Transaction.initialBalance - Transaction.moneySpent;
        }
    }

    //Increases The Transaction Number
    public void increaseTransaction(){
        Transaction.transaction++;
    }

    //Writes The Final Report For The Day On The Report.txt File
    public void reportFileWriter() throws IOException{
        Writer reportWriter = new BufferedWriter(new FileWriter(reportFile,true));
        try{
            reportWriter.write(dateStr + String.format("\nDay Report\n" + "Initial Balance: $%.2f\nMoney Spent: $%.2f\nMoney Gained: $%.2f\nSaved: $%.2f\nLost: $%.2f\nFinal Balance: $%.2f\n", this.getInitialBalance(), this.getTotalMoneySpent(), this.getTotalGain(), this.getSaving(), + this.getTotalLoss(), this.getBalance()));
            reportWriter.write("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
            reportWriter.close();
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    //Opens The Report.txt File
    public void reportFileOpen(){
        Desktop reportDesktop = Desktop.getDesktop();
        try{
        reportDesktop.open(reportFile);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
