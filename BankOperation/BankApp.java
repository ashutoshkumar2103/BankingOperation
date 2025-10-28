import java.util.Scanner;

class BankApp {
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);

                // Hardcoded users
                Account[] users = {
                        new Account("ashu", "1234", "Ashutosh Kumar"),
                        new Account("neha", "abcd", "Neha Sharma"),
                        new Account("rahul", "pass", "Rahul Verma"),
                        new Account("ravi", "1111", "Ravi Singh")
                };

                System.out.println("===== Welcome to Simple Bank System =====");
                System.out.print("Enter username: ");
                String inputUser = sc.nextLine();
                System.out.print("Enter password: ");
                String inputPass = sc.nextLine();

                Account currentUser = null;

                // Login check
                for (Account acc : users) {
                        if (acc.login(inputUser, inputPass)) {
                                currentUser = acc;
                                break;
                        }
                }

                if (currentUser == null) {
                        System.out.println("Invalid username or password. Access denied!");
                        sc.close();
                        return;
                }

                System.out.println("\nWelcome, " + currentUser.holderName + "!");

                int choice;
                do {
                        System.out.println("\n===== Bank Menu =====");
                        System.out.println("1. Deposit");
                        System.out.println("2. Withdraw");
                        System.out.println("3. Check Balance");
                        System.out.println("4. View Transaction History");
                        System.out.println("5. Exit");
                        System.out.print("Enter your choice: ");
                        choice = sc.nextInt();

                        if (choice == 1) {
                                System.out.print("Enter amount to deposit: ");
                                double depositAmt = sc.nextDouble();
                                currentUser.deposit(depositAmt);
                        }
                        else if (choice == 2) {
                                System.out.print("Enter amount to withdraw: ");
                                double withdrawAmt = sc.nextDouble();
                                currentUser.withdraw(withdrawAmt);
                        }
                        else if (choice == 3) {
                                currentUser.checkBalance();
                        }
                        else if (choice == 4) {
                                currentUser.showTransactionHistory();
                        }
                        else if (choice == 5) {
                                System.out.println("Logging out... Thank you for using our bank!");
                        }
                        else {
                                System.out.println("Invalid choice! Try again.");
                                break;
                        }
                } while (choice != 5);

                sc.close();
        }
}
