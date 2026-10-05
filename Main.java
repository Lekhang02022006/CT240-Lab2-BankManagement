/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package th2.th2;

/**
 *
 * @author Admin
 */
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IllegalAccessException {

        Scanner scanner = new Scanner(System.in);

        BankManager manager = new BankManager();

        // Tạo tài khoản mẫu
        SavingAccount acc1 = new SavingAccount(
                "001",
                "Khang",
                100000,
                0.05
        );

        SavingAccount acc2 = new SavingAccount(
                "002",
                "An",
                200000,
                0.04
        );

        manager.addAccount(acc1);
        manager.addAccount(acc2);

        int choice = 0;

        do {
            try {

                System.out.println("\n===== BANK MANAGEMENT =====");
                System.out.println("1. Find account");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Transfer money");
                System.out.println("5. Calculate total balance");
                System.out.println("0. Exit");
                System.out.print("Choose: ");

                choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {

                    case 1:
                        System.out.print("Enter account number: ");
                        String accountNumber = scanner.nextLine();

                        BankAccount account =
                                manager.findAccount(accountNumber);

                        if (account == null) {
                            System.out.println(
                                    "Account not found."
                            );
                        } else {
                            System.out.println(
                                    "Account: "
                                    + account.getAccountNumber()
                            );

                            System.out.println(
                                    "Holder: "
                                    + account.getHolderName()
                            );

                            System.out.println(
                                    "Balance: "
                                    + account.getBalance()
                            );
                        }
                        break;

                    case 2:
                        System.out.print("Account number: ");
                        String depositAcc = scanner.nextLine();

                        System.out.print("Amount: ");
                        double depositAmount =
                                Double.parseDouble(scanner.nextLine());

                        BankAccount depositAccount =
                                manager.findAccount(depositAcc);

                        if (depositAccount == null) {
                            System.out.println(
                                    "Account not found."
                            );
                        } else {
                            depositAccount.deposit(depositAmount);

                            System.out.println(
                                    "Deposit successful."
                            );
                        }
                        break;

                    case 3:
                        System.out.print("Account number: ");
                        String withdrawAcc = scanner.nextLine();

                        System.out.print("Amount: ");
                        double withdrawAmount =
                                Double.parseDouble(scanner.nextLine());

                        BankAccount withdrawAccount =
                                manager.findAccount(withdrawAcc);

                        if (withdrawAccount == null) {
                            System.out.println(
                                    "Account not found."
                            );
                        } else {
                            withdrawAccount.withdraw(withdrawAmount);

                            System.out.println(
                                    "Withdraw successful."
                            );
                        }
                        break;

                    case 4:
                        System.out.print("From account: ");
                        String fromAcc = scanner.nextLine();

                        System.out.print("To account: ");
                        String toAcc = scanner.nextLine();

                        System.out.print("Amount: ");
                        double transferAmount =
                                Double.parseDouble(scanner.nextLine());

                        manager.transferMoney(
                                fromAcc,
                                toAcc,
                                transferAmount
                        );

                        System.out.println(
                                "Transfer successful."
                        );
                        break;

                    case 5:
                        List<BankAccount> accounts =
                                manager.getAllAccounts();

                        double total =
                                manager.calculateTotalBalance(accounts);

                        System.out.println(
                                "Total balance: " + total
                        );
                        break;

                    case 0:
                        System.out.println("Goodbye!");
                        break;

                    default:
                        System.out.println(
                                "Invalid choice."
                        );
                }

            } catch (InvalidAmountException e) {

                System.out.println(
                        "Error: " + e.getMessage()
                );

            } catch (InsufficientBalanceException e) {

                System.out.println(
                        "Error: " + e.getMessage()
                );

            } catch (NumberFormatException e) {

                System.out.println(
                        "Please enter a valid number."
                );

            } catch (Exception e) {

                System.out.println(
                        "Error: " + e.getMessage()
                );
            }

        } while (choice != 0);

        scanner.close();
    }
}
