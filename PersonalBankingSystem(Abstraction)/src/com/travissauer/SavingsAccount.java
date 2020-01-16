package com.travissauer;

public class SavingsAccount extends BankAccount{

    private boolean accountStatus;

    public SavingsAccount(int balance, double annualInterestRate) {
        super(balance, annualInterestRate);
        if (balance < 25){

            System.out.println("Your account has become inactive, please ensure that " +
                    "the content of your Savings Account is above $25");

            accountStatus = false;

        }else{

            accountStatus = true;

        }

    }

    @Override
    public void withdraw(int withdrawalAmount) {

        if (this.getBalance() < 25){

            /*
            I want to enter some user-friendly
            info here that will allow the user to
            see how much money they need to deposit
            for their account to be re-opened
             */
            System.out.println("I'm sorry, but your account is inactive. " +
                    "In order for you to reactivate your account, " +
                    "please deposit an amount that will bring " +
                    "your account balance to 25");

            accountStatus = false;

        }else{

            accountStatus = true;

        }

        if (accountStatus) {

            super.withdraw(withdrawalAmount);

        }
    }

    @Override
    public void deposit(int depositAmount) {

        if (this.getBalance() < 25){

            System.out.println("Your account is currently inactive, " +
                    "please make a sizable deposit for reactivation.");

            accountStatus = false;

        }else{

            accountStatus = true;

        }

        super.deposit(depositAmount);

        if (accountStatus == false){

            if (this.getBalance() > 25){

                /*
                Add some user-friendly info here as well,
                need to display their balance
                 */
                System.out.println("Thank you for your deposit. Your account has been reactivated.");

            }else {

                /*
                Here we need to display how much more the
                customer needs to pay before
                their account becomes active again
                 */
                System.out.println("I'm sorry, but your deposit wasn't" +
                        "sufficient to satisfy our terms for " +
                        "an active account. Please make another deposit " +
                        "for your account to be reactivated");

            }
        }
    }

    @Override
    public double monthlyProcess(double monthlyServiceFees) {

        if (this.getNumOfWithdrawals() > 4){

            monthlyServiceFees += (this.getNumOfWithdrawals() - 4);
            System.out.println("Your withdrawals this month: " + this.getNumOfWithdrawals());
            System.out.println("Because you made " + this.getNumOfWithdrawals() + " withdrawals this month, we have added " +
                    "$1 for every withdrawal over 4 in a month to your monthly processing fee. " +
                    "Increasing your monthly maintenance fee to " + monthlyServiceFees);

        }

        super.monthlyProcess(monthlyServiceFees);

        if (this.getBalance() < 25){

            System.out.println("Your account is negative, please consider making a deposit.");
            accountStatus = false;

        }

        return this.getBalance();

    }
}
