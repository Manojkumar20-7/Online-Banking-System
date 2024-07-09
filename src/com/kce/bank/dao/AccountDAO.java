package com.kce.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.kce.bank.bean.Account;
import com.kce.bank.util.DatabaseConnection;

public class AccountDAO {
	public void addAccount(Account account) 
	{
        String query = "INSERT INTO accounts (customer_id, account_type, balance) VALUES (?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, account.getCustomerId());
            preparedStatement.setString(2, account.getAccountType());
            preparedStatement.setDouble(3, account.getBalance());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Account getAccount(int accountId) 
	{
        Account account = null;
        String query = "SELECT * FROM accounts WHERE account_id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, accountId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                account = new Account();
                account.setId(resultSet.getInt("account_id"));
                account.setCustomerId(resultSet.getInt("customer_id"));
                account.setAccountType(resultSet.getString("account_type"));
                account.setBalance(resultSet.getDouble("balance"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }

    public void updateBalance(int accountId, double newBalance) 
	{
        String query = "UPDATE accounts SET balance = ? WHERE account_id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setDouble(1, newBalance);
            preparedStatement.setInt(2, accountId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
