import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Represents a bank account with a balance and customer information.
 */
public class BankAccount {
    private static final Logger logger = Logger.getLogger(BankAccount.class.getName());
    private String accountNumber;
    private double balance;
    private String customerName;
    private String email;
    private String phoneNumber;
    private AccountType accountType;
    private double overdraftLimit;
    private ArrayList<String> transactionHistory;

    /**
     * Default constructor with default values.
     */
    public BankAccount() {
        this("56789", 2.50, "Default Name", "default@example.com", "000-000-0000", AccountType.CHECKING, 0);
        logger.log(Level.INFO, "Empty constructor called");
    }

    /**
     * Constructs a new BankAccount with the specified details.
     *
     * @param accountNumber the account number
     * @param balance       the initial balance
     * @param customerName  the name of the customer
     * @param email         the email of the customer
     * @param phoneNumber   the phone number of the customer
     * @param accountType   the type of the account
     * @param overdraftLimit the overdraft limit for the account
     */
    public BankAccount(String accountNumber, double balance, String customerName, String email, String phoneNumber, AccountType accountType, double overdraftLimit) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.customerName = customerName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.accountType = accountType;
        this.overdraftLimit = overdraftLimit;
        this.transactionHistory = new ArrayList<>();
        addTransaction("Account created with initial balance: " + balance);
    }

    /**
     * Constructs a new BankAccount with the specified customer details and default account details.
     *
     * @param customerName the name of the customer
     * @param email        the email of the customer
     * @param phoneNumber  the phone number of the customer
     */
    public BankAccount(String customerName, String email, String phoneNumber) {
        this("9999", 100.00, customerName, email, phoneNumber, AccountType.CHECKING, 0);
    }

    // Getters and setters for the fields
    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    public ArrayList<String> getTransactionHistory() {
        return transactionHistory;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public void setOverdraftLimit(double overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }

    /**
     * Adds a transaction to the account.
     *
     * @param transaction the transaction description
     */
    private void addTransaction(String transaction) {
        String timeStampedTransaction = new Date() + ": " + transaction;
        transactionHistory.add(timeStampedTransaction);
        logger.log(Level.INFO, "Transaction recorded: {0}", timeStampedTransaction);
    }

    /**
     * Deposits funds into the account.
     *
     * @param amount the amount to deposit
     */
    public void depositFunds(double amount) {
        if (amount > 0) {
            balance += amount;
            addTransaction("Deposit of " + amount + ". New balance: " + balance);
        } else {
            logger.log(Level.WARNING, "Deposit amount must be greater than zero.");
        }
    }

    /**
     * Withdraws funds from the account.
     *
     * @param amount the amount to withdraw
     */
    public void withdrawFunds(double amount) {
        if (amount > 0) {
            if (balance + overdraftLimit >= amount) {
                balance -= amount;
                addTransaction("Withdrawal of " + amount + ". New balance: " + balance);
            } else {
                logger.log(Level.WARNING, "Insufficient funds for withdrawal. Balance: {0}, Overdraft limit: {1}", new Object[]{balance, overdraftLimit});
            }
        } else {
            logger.log(Level.WARNING, "Withdrawal amount must be greater than zero.");
        }
    }

    /**
     * Calculates interest for the account if it's a savings account.
     *
     * @param interestRate the interest rate
     */
    public void calculateInterest(double interestRate) {
        if (accountType == AccountType.SAVINGS) {
            double interest = balance * (interestRate / 100);
            depositFunds(interest);
            addTransaction("Interest of " + interest + " added. New balance: " + balance);
        } else {
            logger.log(Level.INFO, "Interest calculation only applicable to savings accounts.");
        }
    }
}
