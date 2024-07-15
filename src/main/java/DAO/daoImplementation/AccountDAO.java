package DAO.daoImplementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import DAO.daoInterfaces.AccountInterface;
import Model.Account;
import Util.ConnectionUtil;

public class AccountDAO implements AccountInterface{

    @Override
    public Account register(Account account) {
        Connection connection = ConnectionUtil.getConnection();
        try {
            String query = "insert into account (username, password) values(?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, account.getUsername());
            preparedStatement.setString(2, account.getPassword());
            preparedStatement.executeUpdate();

            ResultSet pkeyResultSet = preparedStatement.getGeneratedKeys();
            if(pkeyResultSet.next()){
                int generated_account_id = (int) pkeyResultSet.getLong(1);
                return new Account(generated_account_id, account.getUsername(), account.getPassword());
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Account loging(Account account) {
        Connection connection = ConnectionUtil.getConnection();
        try {
            String query = "select * from account where username = ? and password = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, account.getUsername());
            preparedStatement.setString(2, account.getPassword());
            
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                return new Account(
                    resultSet.getInt("account_id"), 
                    resultSet.getString("username"), 
                    resultSet.getString("password"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
