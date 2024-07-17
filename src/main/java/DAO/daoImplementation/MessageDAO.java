package DAO.daoImplementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import DAO.daoInterfaces.MessageInterface;
import Model.Message;
import Util.ConnectionUtil;

public class MessageDAO implements MessageInterface{

    @Override
    public Message creatMessage(Message message) {
        Connection connection = ConnectionUtil.getConnection();
        try {
            String query = "insert into message (posted_by, message_text, time_posted_epoch) values(?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, message.getPosted_by());
            preparedStatement.setString(2, message.getMessage_text());
            preparedStatement.setLong(3, message.getTime_posted_epoch());
            preparedStatement.executeUpdate();

            ResultSet pkeyResultSet = preparedStatement.getGeneratedKeys();
            if(pkeyResultSet.next()){
                int generated_message_id = (int) pkeyResultSet.getLong(1);
                return new Message(generated_message_id, message.getPosted_by(), message.getMessage_text(), message.getTime_posted_epoch());
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Message> getAllMessages() {
        Connection connection = ConnectionUtil.getConnection();
        try {
            List<Message> messages = new ArrayList<>();
            String query = "select * from message";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                messages.add(
                    new Message(
                        resultSet.getInt("message_id"),
                        resultSet.getInt("posted_by"),
                        resultSet.getString("message_text"),
                        resultSet.getLong("time_posted_epoch")
                    )
                );
            }
            return messages;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return List.of();
    }

    @Override
    public Message getMessageById(int message_id) {
        Connection connection = ConnectionUtil.getConnection();
        try {
            String query = "select * from message where message_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, message_id);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                return new Message(
                    resultSet.getInt("message_id"), 
                    resultSet.getInt("posted_by"),
                    resultSet.getString("message_text"), 
                    resultSet.getLong("time_posted_epoch"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Message deleteMessageById(int message_id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteMessageById'");
    }

    @Override
    public Message updatMessageByid(int message_id, String message_text) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updatMessageByid'");
    }

    @Override
    public List<Message> registeredUserMessages(int account_id) {
        return getAllMessages().stream().filter(message -> message.getPosted_by() == account_id).collect(Collectors.toList());
    }
    
}
