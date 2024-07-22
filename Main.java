import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Main class to run the bank account management application.
 */
public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean quit = false;
        BankAccount bankAccount = createAccount();
        while (!quit) {
            printActions();
            System.out.println("\nEnter action: ");
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    System.out.println("\nShutting down...");
                    quit = true;
                    break;
                case 1:
                    viewAccountDetails(bankAccount);
                    break;
                case 2:
                    depositFunds(bankAccount);
                    break;
                case 3:
                    withdrawFunds(bankAccount);
                    break;
                case 4:
                    calculateInterest(bankAccount);
                    break;
                case 5:
                    viewTransactionHistory(bankAccount);
                    break;
                default:
                    System.out.println("Invalid action. Please choose a valid option.");
                    break;
            }
        }
    }

    private static BankAccount createAccount() {
        System.out.println("Enter customer name:");
        String customerName = scanner.nextLine();
        System.out.println("Enter email:");
        String email = scanner.nextLine();
        System.out.println("Enter phone number:");
        String phoneNumber = scanner.nextLine();
        System.out.println("Enter account type (CHECKING/SAVINGS):");
        AccountType accountType = AccountType.valueOf(scanner.nextLine().toUpperCase());
        double overdraftLimit = 0;
        if (accountType == AccountType.CHECKING) {
            System.out.println("Enter overdraft limit:");
            overdraftLimit = scanner.nextDouble();
            scanner.nextLine();
        }
        BankAccount bankAccount = new BankAccount(customerName, email, phoneNumber);
        bankAccount.setAccountType(accountType);
        bankAccount.setOverdraftLimit(overdraftLimit);
        return bankAccount;
    }

    private static void viewAccountDetails(BankAccount bankAccount) {
        System.out.println("Customer name: " + bankAccount.getCustomerName());
        System.out.println("Email: " + bankAccount.getEmail());
        System.out.println("Phone number: " + bankAccount.getPhoneNumber());
        System.out.println("Account number: " + bankAccount.getAccountNumber());
        System.out.println("Account type: " + bankAccount.getAccountType());
        System.out.println("Balance: " + bankAccount.getBalance());
        if (bankAccount.getAccountType() == AccountType.CHECKING) {
            System.out.println("Overdraft limit: " + bankAccount.getOverdraftLimit());
        }
    }

    private static void depositFunds(BankAccount bankAccount) {
        System.out.println("Enter deposit amount:");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        bankAccount.depositFunds(amount);
    }

    private static void withdrawFunds(BankAccount bankAccount) {
        System.out.println("Enter withdrawal amount:");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        bankAccount.withdrawFunds(amount);
    }

    private static void calculateInterest(BankAccount bankAccount) {
        if (bankAccount.getAccountType() == AccountType.SAVINGS) {
            System.out.println("Enter interest rate:");
            double interestRate = scanner.nextDouble();
            scanner.nextLine();
            bankAccount.calculateInterest(interestRate);
        } else {
            System.out.println("Interest calculation only applicable to savings accounts.");
        }
    }

    private static void viewTransactionHistory(BankAccount bankAccount) {
        System.out.println("Transaction history:");
        for (String transaction : bankAccount.getTransactionHistory()) {
            System.out.println(transaction);
        }
    }

    private static void printActions() {
        System.out.println("\nAvailable actions:\nPress");
        System.out.println("0 - to shutdown\n" +
                           "1 - to view account details\n" +
                           "2 - to deposit funds\n" +
                           "3 - to withdraw funds\n" +
                           "4 - to calculate interest (savings accounts only)\n" +
                           "5 - to view transaction history\n" +
                           "Choose your action: ");
    }
}
