import java.util.Scanner;

public class ATMOperationImpl implements ATMOperation {
    private ATM atm;

    public ATMOperationImpl(ATM atm) {
        this.atm = atm;
    }

    @Override
    public void viewBalance() {
        atm.checkBalance();
    }

    @Override
    public void withdrawMoney() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the amount you want to withdraw: ");
        double amount = scanner.nextDouble();

        atm.withdrawMoney(amount);
    }

    @Override
    public void depositMoney() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the amount you want to deposit: ");
        double amount = scanner.nextDouble();

        atm.depositMoney(amount);
    }

    @Override
    public void exit() {
        System.out.println("Thank you for using the ATM. Goodbye!");
        System.exit(0);
    }
}