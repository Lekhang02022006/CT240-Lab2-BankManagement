/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package th2.th2;

/**
 *
 * @author Admin
 */
public class SavingAccount extends BankAccount{
    private double interestRate;
    
//    constructor mac dinh
    public SavingAccount(){
        super();
        interestRate = 0.0;
    }
    
//    constructor co tham so
    public SavingAccount(String accountNumber, String holderName, double balance, double interestRate) throws IllegalAccessException{
        super(accountNumber, holderName, balance);
        this.interestRate = interestRate;
        
//      kiem tra invariant
        if (balance < 50000) {
            throw new IllegalAccessException(
                    "Saving account balance must be at least 50000"
            );
        }
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    // Override withdraw
    @Override
    public void withdraw(double amount)
            throws InsufficientBalanceException,
                   InvalidAmountException {

        // Pre-condition
        if (amount <= 0) {
            throw new InvalidAmountException(
                    "Amount must be greater than 0"
            );
        }

        // Số dư sau khi rút
        double newBalance = getBalance() - amount;

        // Không được thấp hơn 50.000
        if (newBalance < 50000) {
            throw new InsufficientBalanceException(
                    "Saving account must maintain minimum balance of 50000"
            );
        }

        // Thực hiện rút tiền
        setBalance(newBalance);
    }
    
}
