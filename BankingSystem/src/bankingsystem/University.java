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
public class University implements Runnable {
private CurrentAccount studentCurrentAccount;
private String threadGroupStr;
private String universityName;
private int amount;
private Long duration;

public University(CurrentAccount studentCurrentAccount, String threadGroupStr, String universityName, int amount) {
    this.studentCurrentAccount = studentCurrentAccount;
    this.threadGroupStr = threadGroupStr;
    this.universityName = universityName;
    this.amount = amount;
}
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Starting");
        Transaction chargeFee = new Transaction(Thread.currentThread().getName(), amount);
        while(studentCurrentAccount.getBalance()< amount) {
        studentCurrentAccount.withdrawal(chargeFee);
         try {
                 duration = (long) (Math.random() * 10000);
                 System.out.println(Thread.currentThread().getName() + ": Duration: " + (duration / 1000) + " seconds");
                 Thread.sleep(duration);  
            } catch (InterruptedException ex) {
                Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        studentCurrentAccount.withdrawal(chargeFee);
        System.out.println(Thread.currentThread().getName() + " Terminating");
    }   
}
