package DAO.daoImplementation;

import java.util.List;

import DAO.daoInterfaces.MessageInterface;
import Model.Message;

public class MessageDAO implements MessageInterface{

    @Override
    public Message creatMessage(Message message) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'creatMessage'");
    }

    @Override
    public List<Message> getAllMessages() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllMessages'");
    }

    @Override
    public Message getMessageById(int message_id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getMessageById'");
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'registeredUserMessages'");
    }
    
}
