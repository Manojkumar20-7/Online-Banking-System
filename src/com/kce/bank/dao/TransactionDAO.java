package com.kce.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.kce.bank.bean.Transaction;

public class TransactionDAO {
	public void addTransaction(Transaction transaction) {
        String query = "INSERT INTO transactions (account_id, transaction_type, amount) VALUES (?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, transaction.getAccountId());
            preparedStatement.setString(2, transaction.getTransactionType());
            preparedStatement.setDouble(3, transaction.getAmount());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
