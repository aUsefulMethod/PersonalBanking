package com.travissauer;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        // instantiating our object with a value
        // that we know should flag the account as inactive
        SavingsAccount account1 = new SavingsAccount(24,.70);

        // proving that we will not be able to withdraw, since
        // we created our object in an inactive state,
        // technically we shouldn't allow our program
        // to create an account with an amount
        // less than the required amount ($25)
        account1.withdraw(500);
        // the accessor method proves that our account
        // did not let our user make a withdrawal
        // because our counter was not incremented
        System.out.println("# of withdrawals: " + account1.getNumOfWithdrawals());
        // check our balance just to make sure
        System.out.println("Balance is : " + account1.getBalance());

        // make a deposit so that our account is active
        // and so that we can further illustrate the program
        account1.deposit(1000);

        JOptionPane.showMessageDialog(null, "Your account balance is:\n" + account1.getBalance());

        // just trying to increment our
        // withdrawal counter
        // so that we can test
        // whether or not our monthly processing method works
        account1.withdraw(20);
        account1.withdraw(20);
        account1.withdraw(20);
        account1.withdraw(20);
        account1.withdraw(20);
        account1.withdraw(20);
        account1.withdraw(20);
        account1.withdraw(20);
        account1.withdraw(20);
        account1.withdraw(20);
        account1.withdraw(20);

        JOptionPane.showMessageDialog(null, "Your account balance is:\n" + account1.getBalance());

        // ok so we reset our monthly counters here
        // our calcInterest method is called inside the monthlyProcess method
        // then everything is reset, simulating the start of a new month
        account1.monthlyProcess(20);

        // so when we call on our accessor method here,
        // we should find out that our counter
        // has been reset to 0
        System.out.println("Number of withdrawals: " + account1.getNumOfWithdrawals());
        System.out.println("# of deposits: " + account1.getNumOfDeposits());
        System.out.println("Current Balance: " + account1.getBalance());



    }

}
