/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankingsystem;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Claudio
 */
public class CurrentAccount implements BankAccount {
    private final Semaphore semaphore; ///***
    private final String accountHolder; 
    private final int accountNumber;
    private String customerID;
    private int amount;
    private int balance;
    private final Statement currentAccountStatement;
    
    public CurrentAccount(String accountHolder, int accountNumber, String customerID, int balance) {
        semaphore = new Semaphore(1,true); ///***
        this.currentAccountStatement = new Statement(accountHolder,accountNumber);
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.customerID = customerID;
        this.balance = balance; 
    }
        
    @Override
    public int getBalance() {
         return balance;
    }

    @Override
    public int getAccountNumber() {
        return accountNumber;
    }

    @Override
    public String getAccountHolder() {
        return accountHolder;
    }

    @Override
    public void deposit(Transaction t) {
      try
      {
         semaphore.acquire();
         customerID = t.getCID();
         amount = t.getAmount();
         balance = balance + t.getAmount();
         currentAccountStatement.addTransaction(customerID, amount, balance);
     System.out.printf("%s: Deposit has been made\n", Thread.currentThread().getName());
      } 
      catch (InterruptedException e)
      {
         e.printStackTrace();
         System.out.printf("%s: ERROR making deposit\n", Thread.currentThread().getName());
      } 
      finally
      {
         semaphore.release();
      }
    }

    @Override
    public void withdrawal(Transaction t) {
    try
      {
         semaphore.acquire();
         customerID = t.getCID();
         amount = t.getAmount();
    if(isOverdrawn()) {
        System.out.println(Thread.currentThread().getName() + ": NOT ENOUGH BALANCE TO PERFORM TRANSACTION");
    }
    else {
         balance = balance - amount;
         currentAccountStatement.addTransaction(customerID, amount, balance);
         System.out.printf("%s: Withdrawal has been made\n", Thread.currentThread().getName());
     }
        
      } 
      catch (InterruptedException e)
      {
         e.printStackTrace();
      } 
      finally
      {
         semaphore.release();
      }
    }

    @Override
    public boolean isOverdrawn() {
       return balance < amount;
    }

    @Override
    public void printStatement() {
     try
      {
         semaphore.acquire();
         currentAccountStatement.print();  
      } 
      catch (InterruptedException e)
      {
         e.printStackTrace();
      } 
      finally
      {
         System.out.printf("%s: Statement has been printed\n", Thread.currentThread().getName());
         semaphore.release();
      }  
    }
}
