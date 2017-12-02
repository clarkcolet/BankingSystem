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
public class LoanCompany implements Runnable {
    private CurrentAccount studentCurrentAccount;
    private String threadGroupStr;
    private String companyName;
    private int amount;
    private Long duration;
    
    public LoanCompany(CurrentAccount studentCurrentAccount, String threadGroupStr, String companyName, int amount) {
        this.studentCurrentAccount = studentCurrentAccount;
        this.threadGroupStr = threadGroupStr;  
        this.companyName = companyName;
        this.amount = amount;
    }
    
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Starting");
        duration = (long) (Math.random() * 10000);
        try {
                Thread.sleep(duration);
                 System.out.println(Thread.currentThread().getName() + ": Duration: " + (duration / 1000) + " seconds");
            } catch (InterruptedException ex) {
                Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
            }
        Transaction makeLoan = new Transaction(Thread.currentThread().getName(), amount);
        studentCurrentAccount.deposit(makeLoan);  
        System.out.println(Thread.currentThread().getName() + ": Terminating");
    }
}

