/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package th2.th2;

/**
 *
 * @author Admin
 */
public abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if (balance < 0){
            throw new IllegalArgumentException("Balance cannot be negative");
        }

        this.balance = balance;
    }

    public BankAccount(){
        accountNumber = "";
        holderName = "";
        balance = 0.0;
    }

    public BankAccount (String aN, String hN, double b) {
        accountNumber = aN;
        holderName = hN;
        setBalance(b);
    }

    public void deposit() throws InvalidAmountException {
        deposit(0.0);
    }

    public void deposit(double amount) throws InvalidAmountException {
        if (amount <= 0) {
            throw new InvalidAmountException("Amount must be greater than 0");
        }

        double oldBalance = balance;
        balance = balance + amount;

        // Post-condition
        assert balance == oldBalance + amount;
    }

    // Phương thức trừu tượng withdraw

    public abstract void withdraw(double amount)
            throws InsufficientBalanceException, InvalidAmountException;
}
