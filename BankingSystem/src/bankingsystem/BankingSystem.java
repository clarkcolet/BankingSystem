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
public class BankingSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       //Accounts for Jim and Sue
        System.out.println("Starting...");
       CurrentAccount currentStudentAccount_Jim = new CurrentAccount("Jim", 123456, "JIM123",0);
       CurrentAccount currentStudentAccount_Sue = new CurrentAccount("Sue", 654321, "SUE654",0);
       //Creation of Threadgroups
       ThreadGroup threadGroupStudents = new ThreadGroup("ThreadGroup_Students") ;
       ThreadGroup threadLoanUniv = new ThreadGroup("ThreadGroup_LoanUniv");
       //Creation of threads JIM
       Thread makeDepositJim = new Thread(threadGroupStudents, new Student(currentStudentAccount_Jim, "make deposit", threadGroupStudents.getName(), 1000), "Jim: Deposit");
       Thread buyIphoneJim   = new Thread(threadGroupStudents, new Student(currentStudentAccount_Jim, "buy iphone", threadGroupStudents.getName(), 700), "Jim: Buy iPhone");
       Thread getCashOutJim  = new Thread(threadGroupStudents, new Student(currentStudentAccount_Jim, "get cash", threadGroupStudents.getName(),100), "Jim: Get cash");
       Thread receiveGiftJim = new Thread(threadGroupStudents, new Student(currentStudentAccount_Jim, "receive gift", threadGroupStudents.getName(),650), "Jim: Receive gift");
       Thread buyIpadJim     = new Thread(threadGroupStudents, new Student(currentStudentAccount_Jim, "buy ipad", threadGroupStudents.getName(),800), "Jim: Buy iPad");
       Thread buyFoodJim     = new Thread(threadGroupStudents, new Student(currentStudentAccount_Jim, "buy food", threadGroupStudents.getName(),50), "Jim: Buy food");
       Thread statementJim   = new Thread(threadGroupStudents, new Student(currentStudentAccount_Jim, "print statement", threadGroupStudents.getName(),0), "Jim: Printing Statement"); 
       //Creation of threads SUE
       Thread makeDepositSue = new Thread(threadGroupStudents, new Student(currentStudentAccount_Sue, "make deposit", threadGroupStudents.getName(),2000), "Sue: Deposit");
       Thread buyIphoneSue   = new Thread(threadGroupStudents, new Student(currentStudentAccount_Sue, "buy iphone", threadGroupStudents.getName(),700), "Sue: Buy iPhone ");
       Thread getCashOutSue  = new Thread(threadGroupStudents, new Student(currentStudentAccount_Sue, "get cash", threadGroupStudents.getName(),250), "Sue: Get cash");
       Thread receiveGiftSue = new Thread(threadGroupStudents, new Student(currentStudentAccount_Sue, "receive gift", threadGroupStudents.getName(),100), "Sue: Receive gift");
       Thread buyIpadSue     = new Thread(threadGroupStudents, new Student(currentStudentAccount_Sue, "buy ipad", threadGroupStudents.getName(),800), "Sue: Buy iPad");
       Thread buyFoodSue     = new Thread(threadGroupStudents, new Student(currentStudentAccount_Sue, "buy food", threadGroupStudents.getName(),60), "Sue: Buy food");
       Thread statementSue   = new Thread(threadGroupStudents, new Student(currentStudentAccount_Sue, "print statement", threadGroupStudents.getName(),0), "Sue: Print Statement");
       //
       //Creation of threads LOAN COMPANY - JIM
       Thread makeLoan_Jim[] = new Thread[3];
       makeLoan_Jim[0] = new Thread(threadLoanUniv, new LoanCompany(currentStudentAccount_Jim, threadLoanUniv.getName(), "Loan Inc.", 5000), "Loan Company: Deposit");
       makeLoan_Jim[1] = new Thread(threadLoanUniv, new LoanCompany(currentStudentAccount_Jim, threadLoanUniv.getName(), "Loan Inc.", 2000), "Loan Company: Deposit");
       makeLoan_Jim[2] = new Thread(threadLoanUniv, new LoanCompany(currentStudentAccount_Jim, threadLoanUniv.getName(), "Loan Inc.", 3000), "Loan Company: Deposit");
       //Creation of threads LOAN COMPANY - SUE
       Thread makeLoan_Sue[] = new Thread[3];
       makeLoan_Sue[0] = new Thread(threadLoanUniv, new LoanCompany(currentStudentAccount_Sue, threadLoanUniv.getName(), "Loan Inc.", 5000), "Loan Company: Deposit");
       makeLoan_Sue[1] = new Thread(threadLoanUniv, new LoanCompany(currentStudentAccount_Sue, threadLoanUniv.getName(), "Loan Inc.", 2000), "Loan Company: Deposit");
       makeLoan_Sue[2] = new Thread(threadLoanUniv, new LoanCompany(currentStudentAccount_Sue, threadLoanUniv.getName(), "Loan Inc.", 3000), "Loan Company: Deposit");
       //Creation of threads UNIVERSITY - JIM
       Thread feeWithdrawal_Jim[] = new Thread[3];
       feeWithdrawal_Jim[0] = new Thread(threadLoanUniv, new University(currentStudentAccount_Jim, threadLoanUniv.getName(), "University of Westminster", 5000), "University: Withdraw");
       feeWithdrawal_Jim[1] = new Thread(threadLoanUniv, new University(currentStudentAccount_Jim, threadLoanUniv.getName(), "University of Westminster", 2000), "University: Withdraw");
       feeWithdrawal_Jim[2] = new Thread(threadLoanUniv, new University(currentStudentAccount_Jim, threadLoanUniv.getName(), "University of Westminster", 3000), "University: Withdraw");
       //Creation of threads UNIVERSITY - SUE
       Thread feeWithdrawal_Sue[] = new Thread[3];
       feeWithdrawal_Sue[0] = new Thread(threadLoanUniv, new University(currentStudentAccount_Sue, threadLoanUniv.getName(), "University of Westminster", 5000), "University: Withdraw");
       feeWithdrawal_Sue[1] = new Thread(threadLoanUniv, new University(currentStudentAccount_Sue, threadLoanUniv.getName(), "University of Westminster", 2000), "University: Withdraw");
       feeWithdrawal_Sue[2] = new Thread(threadLoanUniv, new University(currentStudentAccount_Sue, threadLoanUniv.getName(), "University of Westminster", 3000), "University: Withdraw");
       //

       //Starting threads for JIM
       makeDepositJim.start();
       buyIphoneJim.start();
       getCashOutJim.start();
       receiveGiftJim.start();
       buyIpadJim.start();
       buyFoodJim.start();
       makeLoan_Jim[0].start();
       makeLoan_Jim[1].start();
       makeLoan_Jim[2].start();
       feeWithdrawal_Jim[0].start();
       feeWithdrawal_Jim[1].start();
       feeWithdrawal_Jim[2].start();
       
       //Starting threads for SUE
       makeDepositSue.start();
       buyIphoneSue.start();
       getCashOutSue.start();
       receiveGiftSue.start();
       buyIpadSue.start();
       buyFoodSue.start();
       makeLoan_Sue[0].start();
       makeLoan_Sue[1].start();
       makeLoan_Sue[2].start();
       feeWithdrawal_Sue[0].start();
       feeWithdrawal_Sue[1].start();
       feeWithdrawal_Sue[2].start();

        try {
         //JIM
            makeDepositJim.join();
            buyIphoneJim.join();
            getCashOutJim.join();
            receiveGiftJim.join();
            buyIpadJim.join();
            buyFoodJim.join();
            makeLoan_Jim[0].join();
            makeLoan_Jim[1].join();
            makeLoan_Jim[2].join();
            feeWithdrawal_Jim[0].join();
            feeWithdrawal_Jim[1].join();
            feeWithdrawal_Jim[2].join();
            
            //Print final statement for Jim
            statementJim.start();
            statementJim.join();

            //SUE
            makeDepositSue.join();
            buyIphoneSue.join();
            getCashOutSue.join();
            receiveGiftSue.join();
            buyIpadSue.join();
            buyFoodSue.join();
            makeLoan_Sue[0].join();
            makeLoan_Sue[1].join();
            makeLoan_Sue[2].join();
            feeWithdrawal_Sue[0].join();
            feeWithdrawal_Sue[1].join();
            feeWithdrawal_Sue[2].join();
            Thread.sleep(5000);
            //Print final statement for Jim
            statementSue.start();
            statementSue.join();
            System.out.println("...finished");
        } catch (InterruptedException ex) {
            Logger.getLogger(BankingSystem.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
