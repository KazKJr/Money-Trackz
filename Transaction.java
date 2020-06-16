package com.MoneyTrackz;

import java.text.*;
import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.StrictMath.*;

public class Transaction {
    private static double initialBalance, spent, totalSpent, gain, totalGain, balance, saving, loss,  profit;//These Are Static Because Main and BrightMain Screens Data Did Not Save Unless They Were Static
    private static int transactionNumber;
    private DateFormat dateFormat = new SimpleDateFormat("E dd MMM yyyy");
    private Date date = new Date();
    private File reportFile = new File("Report.txt");
    public String dateStr = dateFormat.format(date);

    //Getter And Setters For The Variables
    public static double getInitialBalance() {
        return initialBalance;
    }

    public static void setInitialBalance(double initialBalance) {
        Transaction.initialBalance = initialBalance;
    }

    public static double getSpent() {
        return spent;
    }

    public static void setSpent(double spent) {
        Transaction.spent = spent;
    }

    public static double getTotalSpent() {
        return totalSpent;
    }

    public static void setTotalSpent(double totalSpent) {
        Transaction.totalSpent = totalSpent;
    }

    public static double getGain() {
        return gain;
    }

    public static void setGain(double gain) {
        Transaction.gain = gain;
    }

    public static double getTotalGain() {
        return totalGain;
    }

    public static void setTotalGain(double totalGain) {
        Transaction.totalGain = totalGain;
    }

    public static double getBalance() {
        return balance;
    }

    public static void setBalance(double balance) {
        Transaction.balance = balance;
    }

    public static double getSaving() {
        return saving;
    }

    public static void setSaving(double saving) {
        Transaction.saving = saving;
    }

    public static double getLoss() {
        return loss;
    }

    public static void setLoss(double loss) {
        Transaction.loss = loss;
    }

    public static double getProfit() {
        return profit;
    }

    public static void setProfit(double profit) {
        Transaction.profit = profit;
    }

    public static int getTransactionNumber() {
        return transactionNumber;
    }

    public static void setTransactionNumber(int transactionNumber) {
        Transaction.transactionNumber = transactionNumber;
    }

    //Calculates The Amount Of Money Spent After Each Transaction Where Money Was Spent
    public void calculateBalanceSpent(){
        Transaction.balance -= Transaction.spent;
    }

    //Calculates The Amount Of Money Gained After Each Transaction Where Money Was Gained
    public void calculateBalanceGained(){
        Transaction.balance += Transaction.gain;
    }

    //Calculates The Total Amount Of Money Spent After Each Transaction Where Money Was Spent
    public void calculateTotalSpent(){
        Transaction.totalSpent += Transaction.spent;
    }

    //Calculates The Total Amount Of Money Gained After Each Transaction Where Money Was Gained
    public void calculateTotalMoneyGained(){
        Transaction.totalGain += Transaction.gain;
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
            Transaction.loss = abs(Transaction.balance);
        } else{
            Transaction.loss = 0;
        }
    }

    //Calculates How Much Money Was Profited After Each Transaction
    public void calculateProfit(){
        if(Transaction.balance > Transaction.initialBalance){
            Transaction.profit = Transaction.balance - Transaction.initialBalance;
        } else{
            Transaction.profit = 0;
        }
    }

    //Increases The Transaction Number
    public void increaseTransactionNumber(){
        Transaction.transactionNumber++;
    }

    //Writes The Final Report For The Day On The Report.txt File
    public void reportFileWriter() throws IOException{
        Writer reportWriter = new BufferedWriter(new FileWriter(reportFile,true));
        try{
            reportWriter.write(dateStr + String.format("\nDay Report\n" + "Initial Balance: $%.2f\nTotal Money Spent: $%.2f\nTotal Money Gained: $%.2f\nSaved: $%.2f\nLost: $%.2f\n Profit: $%.2f\nFinal Balance: $%.2f\n", Transaction.initialBalance, Transaction.totalSpent, Transaction.totalGain, Transaction.saving, + Transaction.loss, Transaction.profit, Transaction.balance));
            reportWriter.write("~End Of Report~");
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
