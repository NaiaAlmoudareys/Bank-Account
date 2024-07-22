# Advanced Bank Account Management System

## Overview

The Advanced Bank Account Management System is a Java application designed to manage bank accounts, including customer information, balances, transactions, and account types. It provides a user-friendly interface to view and manage bank accounts with additional features like overdraft protection and interest calculation.

## Features

- **Account Management**: Create and manage bank accounts with different types (Checking, Savings).
- **Customer Information**: Store and display customer information.
- **Transaction Management**: Perform deposit and withdrawal transactions.
- **Overdraft Protection**: Allow overdraft for checking accounts.
- **Interest Calculation**: Calculate interest for savings accounts.
- **Transaction History**: Maintain a history of all transactions.
- **User Interface**: Console-based interface for easy interaction.
- **Logging**: Logging functionality for better debugging and monitoring.

## How to Use

1. **Start the Application**: Run the `Main` class to start the application.
2. **Create Accounts**: Follow the prompts to create a bank account with customer details and account type.
3. **Perform Transactions**: Use the menu options to deposit, withdraw, and view transactions.
4. **Calculate Interest**: Calculate interest for savings accounts.
5. **View Account Details**: Use the menu to view detailed account information and transaction history.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) installed on your computer.

### Installation

1. Clone the repository or download the source code.
2. Open the project in your preferred Java IDE (e.g., IntelliJ IDEA, Eclipse).
3. Ensure the JDK is correctly set up in your IDE.

### Running the Application

1. Compile and run the `Main` class.
2. Follow the on-screen instructions to interact with the application.

## Code Structure

- **Main.java**: Contains the main application logic and user interface.
- **BankAccount.java**: Defines the BankAccount class, including methods for managing accounts, performing transactions, and calculating interest.
- **AccountType.java**: Enumeration for different types of bank accounts (Checking, Savings).

## Example Usage

1. Create a new bank account:
   ```java
   BankAccount bankAccount = new BankAccount("12345", 0.00, "Bob", "myemail@gmail.com", "3439984077", AccountType.CHECKING, 500);
