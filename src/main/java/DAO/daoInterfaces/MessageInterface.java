package DAO.daoInterfaces;

import java.util.List;

import Model.Message;

public interface MessageInterface {
    Message creatMessage(Message message);
    List<Message> getAllMessages();
    Message getMessageById(int message_id);
    void deleteMessageById(int message_id);
    void updatMessageByid(int message_id, String message_text);
    List<Message> registeredUserMessages(int account_id);
}
