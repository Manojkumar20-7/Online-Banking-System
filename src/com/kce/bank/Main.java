package com.kce.bank;

import java.util.Scanner;
import com.kce.bank.bean.Account;
import com.kce.bank.bean.Customer;
import com.kce.bank.dao.AccountDAO;
import com.kce.bank.dao.CustomerDAO;
import com.kce.bank.service.BankingService;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankingService bankingService = new BankingService();
        
        while (true) 
		{
            System.out.println("1. Create Customer");
            System.out.println("2. Create Account");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Exit");
            int choice = scanner.nextInt();
            switch (choice) 
			{
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.next();
                    System.out.print("Enter email: ");
                    String email = scanner.next();
                    System.out.print("Enter phone: ");
                    String phone = scanner.next();
                    Customer customer = new Customer();
                    customer.setName(name);
                    customer.setEmail(email);
                    customer.setPhone(phone);
                    new CustomerDAO().addCustomer(customer);
                    break;
                case 2:
                    System.out.print("Enter customer ID: ");
                    int customerId = scanner.nextInt();
                    System.out.print("Enter account type: ");
                    String accountType = scanner.next();
                    System.out.print("Enter initial balance: ");
                    double balance = scanner.nextDouble();
                    Account account = new Account();
                    account.setCustomerId(customerId);
                    account.setAccountType(accountType);
                    account.setBalance(balance);
                    new AccountDAO().addAccount(account);
                    break;
                case 3:
                    System.out.print("Enter account ID: ");
                    int accountId = scanner.nextInt();
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    bankingService.deposit(accountId, depositAmount);
                    break;
                case 4:
                    System.out.print("Enter account ID: ");
                    int withdrawAccountId = scanner.nextInt();
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    bankingService.withdraw(withdrawAccountId, withdrawAmount);
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }
}
