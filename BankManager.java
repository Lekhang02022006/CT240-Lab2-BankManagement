/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package th2.th2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

/**
 *
 * @author Admin
 */
public class BankManager {

    private Map<String, BankAccount> accounts;

    public BankManager() {
        accounts = new HashMap<>();
    }

    // Thêm tài khoản
    public void addAccount(BankAccount account) {
        accounts.put(account.getAccountNumber(), account);
    }

    // Tìm tài khoản
    public BankAccount findAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }

    // Chuyển tiền
    public void transferMoney(String fromAcc, String toAcc, double amount)
            throws InvalidAmountException,
                   InsufficientBalanceException {

        BankAccount from = findAccount(fromAcc);
        BankAccount to = findAccount(toAcc);

        if (from == null) {
            throw new IllegalArgumentException(
                    "Source account does not exist"
            );
        }

        if (to == null) {
            throw new IllegalArgumentException(
                    "Destination account does not exist"
            );
        }

        if (amount <= 0) {
            throw new InvalidAmountException(
                    "Transfer amount must be greater than 0"
            );
        }

        // Rút tiền từ tài khoản nguồn
        from.withdraw(amount);

        // Nạp tiền vào tài khoản đích
        to.deposit(amount);
    }

    // Tính tổng số dư
    public double calculateTotalBalance(
            List<? extends BankAccount> accounts) {

        double total = 0.0;

        for (BankAccount acc : accounts) {
            total += acc.getBalance();
        }

        return total;
    }

    // Lấy tất cả tài khoản
    public List<BankAccount> getAllAccounts() {
        return new ArrayList<>(accounts.values());
    }
}
