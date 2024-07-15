package DAO.daoInterfaces;

import java.util.List;

import Model.Message;

public interface MessageInterface {
    Message creatMessage(Message message);
    List<Message> getAllMessages();
    Message getMessageById(int message_id);
    Message deleteMessageById(int message_id);
    Message updatMessageByid(int message_id, String message_text);
    List<Message> registeredUserMessages(int account_id);
}
