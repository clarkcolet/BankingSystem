/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankingsystem;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Claudio
 */
class Student implements Runnable {
    private CurrentAccount studentCurrentAccount;
    private String transactionStr;
    private Long duration;
    private String groupThreadStr;
    private int amount;
    
    public Student(CurrentAccount studentCurrentAccount, String transactionStr, String groupThreadStr, int amount) {
        this.studentCurrentAccount = studentCurrentAccount;
        this.transactionStr = transactionStr;
        this.groupThreadStr = groupThreadStr;
        this.amount = amount;
    }
    
    @Override
    public void run() {
    duration = (long) (Math.random() * 10000);
    System.out.println(Thread.currentThread().getName() + ": Starting");
      switch(transactionStr){
        case "make deposit":
         System.out.println(Thread.currentThread().getName() + ": Duration: " + (duration / 1000) + " seconds");
            try {
                Thread.sleep(duration);
            } catch (InterruptedException ex) {
                Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
            }
            Transaction makeDeposit = new Transaction(Thread.currentThread().getName(), amount);
            studentCurrentAccount.deposit(makeDeposit);
        break;
        case "buy iphone":
            Transaction buyIphone = new Transaction(Thread.currentThread().getName(), amount);
            while(studentCurrentAccount.getBalance() < amount){
            studentCurrentAccount.withdrawal(buyIphone); 
            try {
                duration = (long) (Math.random() * 100000);
                System.out.println(Thread.currentThread().getName() + ": Duration: " + (duration / 1000) + " seconds");
                Thread.sleep(duration);   
            } catch (InterruptedException ex) {
                Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
            studentCurrentAccount.withdrawal(buyIphone); 
            break;
        case "get cash":
            Transaction getCash = new Transaction(Thread.currentThread().getName(), amount);
            while(studentCurrentAccount.getBalance() < amount) {
            studentCurrentAccount.withdrawal(getCash); 
            try {
                 duration = (long) (Math.random() * 10000);
                 System.out.println(Thread.currentThread().getName() + ": Duration: " + (duration / 1000) + " seconds");
                 Thread.sleep(duration);  
            } catch (InterruptedException ex) {
                Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
            studentCurrentAccount.withdrawal(getCash); 
            break;
        case "receive gift":
            try {
                Thread.sleep(duration);
                System.out.println(Thread.currentThread().getName() + ": Duration: " + (duration / 1000) + " seconds");
            } catch (InterruptedException ex) {
                Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
            }
            Transaction receiveGift = new Transaction(Thread.currentThread().getName(), amount);
            studentCurrentAccount.deposit(receiveGift);
            break;
        case "buy ipad":
            Transaction buyIpad = new Transaction(Thread.currentThread().getName(), amount);
            while(studentCurrentAccount.getBalance() < amount) {
            studentCurrentAccount.withdrawal(buyIpad); 
            try {
                duration = (long) (Math.random() * 10000);
                System.out.println(Thread.currentThread().getName() + ": Duration: " + (duration / 1000) + " seconds");
                Thread.sleep(duration);
               } catch (InterruptedException ex) {
                Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
            studentCurrentAccount.withdrawal(buyIpad); 
            break;
        case "buy food":
            Transaction buyFood = new Transaction(Thread.currentThread().getName(), amount);
            while(studentCurrentAccount.getBalance() < amount) {
            studentCurrentAccount.withdrawal(buyFood);
            try {
            duration = (long) (Math.random() * 10000);
            System.out.println(Thread.currentThread().getName() + ": Duration: " + (duration / 1000) + " seconds");
            Thread.sleep(duration);
               } catch (InterruptedException ex) {
                Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
            } 
            }
            studentCurrentAccount.withdrawal(buyFood);
            break;
       case "print statement":
            studentCurrentAccount.printStatement();
            break;
        default:
            System.out.println("ENTERED IN SWITCH DEFAULT");
        }
     System.out.println(Thread.currentThread().getName() + ": Terminating");
    }
    
}

