package atm;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Card Number: ");
        String card = sc.next();
        System.out.print("Enter PIN: ");
        int pin = sc.nextInt();

        while (true) {
            System.out.println("\n1. Balance  2. Deposit  3. Withdraw  4. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Balance: " + ATMOperations.checkBalance(card));
                    break;
                case 2:
                    System.out.print("Amount to deposit: ");
                    ATMOperations.deposit(card, sc.nextDouble());
                    System.out.println("Amount deposited successfully!");
                    break;
                case 3:
                    System.out.print("Amount to withdraw: ");
                    double amount = sc.nextDouble();
                    double balance = ATMOperations.checkBalance(card);
                    if (amount > balance) {
                        System.out.println("Insufficient balance!");
                    } else {
                        ATMOperations.withdraw(card, amount);
                        System.out.println("Amount withdrawn successfully!");
                    }
                    break;
                case 4:
                    System.out.println("Thank you for using ATM!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
