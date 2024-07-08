
# Online Banking System

## Overview

The **Online Banking System** is a console-based application developed in Java using JDBC to connect to a MySQL database. It allows users to perform basic banking operations such as creating an account, depositing and withdrawing funds, transferring money, and viewing transaction history.

## Features

- **User Registration**: Create a new user account.
- **Account Management**: View account balance, transaction history.
- **Deposit and Withdrawal**: Perform deposit and withdrawal transactions.
- **Fund Transfer**: Transfer funds between accounts.
- **Secure Authentication**: User login with password authentication.

## Technologies Used

- **Java**: Core programming language used to develop the application.
- **JDBC**: Java Database Connectivity (JDBC) is used for connecting and executing queries to the MySQL database.
- **MySQL**: Database management system used to store user and transaction data.

## Prerequisites

- **Java Development Kit (JDK)**: Ensure you have JDK 8 or later installed.
- **MySQL**: Install MySQL server and create a database for the application.
- **MySQL JDBC Driver**: Include the MySQL JDBC driver in your project.

## Installation

1. **Clone the Repository**
    ```bash
    git clone https://github.com/your-username/online-banking-system.git
    ```
2. **Set Up the Database**
    - Start your MySQL server.
    - Create a database for the project:
      ```sql
      CREATE DATABASE banking_system;
      ```
    - Import the provided SQL script to create the required tables.
    ```bash
    mysql -u your-username -p banking_system < path/to/schema.sql
    ```
3. **Configure Database Connection**
    - Update the `DBConnection.java` file with your MySQL database credentials.
    ```java
    // DBConnection.java
    String url = "jdbc:mysql://localhost:3306/banking_system";
    String user = "your-username";
    String password = "your-password";
    ```

4. **Build and Run the Application**
    - Compile the project:
      ```bash
      javac -cp .:path/to/mysql-connector-java.jar your/package/Main.java
      ```
    - Run the application:
      ```bash
      java -cp .:path/to/mysql-connector-java.jar your.package.Main
      ```
