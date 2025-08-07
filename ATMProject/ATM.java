import java.util.Scanner;

public class ATM {
    private Bank bank;
    private Scanner sc;

    public ATM(Bank bank) {
        this.bank = bank;
        this.sc = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Welcome to the ATM Interface!");

        System.out.print("Enter User ID: ");
        String userId = sc.nextLine();

        System.out.print("Enter PIN: ");
        String pin = sc.nextLine();

        User user = bank.login(userId, pin);
        if (user == null) {
            System.out.println(" Invalid credentials. Exiting...");
            return;
        }

        System.out.println(" Login successful!\n");

        boolean running = true;
        while (running) {
            System.out.println("\n--- ATM Menu ---");
            System.out.println("1.Transactions History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");
            System.out.print("Select an option: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    user.printTransactionHistory();
                    break;

                case 2:
                    System.out.print("Enter amount to withdraw: Rs.");
                    double withdrawAmount = sc.nextDouble();
                    if (user.withdraw(withdrawAmount)) {
                        System.out.println("Withdrawal successful.");
                    } else {
                        System.out.println("Insufficient balance.");
                    }
                    break;

                case 3:
                    System.out.print("Enter amount to deposit: Rs.");
                    double depositAmount = sc.nextDouble();
                    user.deposit(depositAmount);
                    System.out.println(" Deposit successful.");
                    break;

                case 4:
                    System.out.print("Enter recipient User ID: ");
                    String recipientId = sc.nextLine();
                    User recipient = bank.getUser(recipientId);
                    if (recipient == null) {
                        System.out.println("Recipient not found.");
                        break;
                    }

                    System.out.print("Enter amount to transfer: Rs.");
                    double transferAmount = sc.nextDouble();
                    if (user.transfer(recipient, transferAmount)) {
                        System.out.println("Transfer successful.");
                    } else {
                        System.out.println("Insufficient balance.");
                    }
                    break;

                case 5:
                    running = false;
                    System.out.println("Thank you for using the ATM.");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
