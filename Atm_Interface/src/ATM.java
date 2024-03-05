import java.util.Scanner;

public class ATM {
    private int pin;
    private double balance;

    public ATM(int pin, double balance) {
        this.pin = pin;
        this.balance = balance;
    }

    public boolean authenticate(int inputPin) {
        return inputPin == pin;
    }

    public void checkBalance() {
        System.out.printf("Your balance is: $%.2f%n", balance);
    }

    public void withdrawMoney(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds.");
        } else {
            balance -= amount;
            System.out.printf("You withdrew $%.2f. Your new balance is: $%.2f%n", amount, balance);
        }
    }

    public void depositMoney(double amount) {
        balance += amount;
        System.out.printf("You deposited $%.2f. Your new balance is: $%.2f%n", amount, balance);
    }

    public static void main(String[] args) {
        ATM atm = new ATM(1234, 1000);
        ATMOperationImpl atmOperation = new ATMOperationImpl(atm);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter your pin: ");
            int pin = scanner.nextInt();

            if (atm.authenticate(pin)) {
                while (true) {
                    System.out.println("\nChoose an option:");
                    System.out.println("1. Check balance");
                    System.out.println("2. Withdraw money");
                    System.out.println("3. Deposit money");
                    System.out.println("4. Exit");

                    int choice = scanner.nextInt();

                    switch (choice) {
                        case 1:
                            atmOperation.viewBalance();
                            break;
                        case 2:
                            atmOperation.withdrawMoney();
                            break;
                        case 3:
                            atmOperation.depositMoney();
                            break;
                        case 4:
                            atmOperation.exit();
                            break;
                        default:
                            System.out.println("Invalid choice.");
                    }
                }
            } else {
                System.out.println("Invalid pin.");
            }
        }
    }
}