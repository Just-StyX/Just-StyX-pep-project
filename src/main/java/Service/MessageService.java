package Service;

import java.util.List;

import DAO.daoImplementation.AccountDAO;
import DAO.daoImplementation.MessageDAO;
import DAO.daoInterfaces.AccountInterface;
import DAO.daoInterfaces.MessageInterface;
import Model.Account;
import Model.Message;

public class MessageService {
    MessageInterface messageInterface = new MessageDAO();
    AccountInterface accountInterface = new AccountDAO();

    public Message creatMessage(Message message) {
        if (!message.getMessage_text().isBlank() && message.getMessage_text().length() < 255) {
            Account account = accountInterface.getAccountById(message.getPosted_by());
            if (account != null) {
                return messageInterface.creatMessage(message);
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    public List<Message> getAllMessages() {
        return messageInterface.getAllMessages();
    }

    public Message getMessageByMessageId(int message_id) {
        return messageInterface.getMessageById(message_id);
    }

    public List<Message> registeredUserMessages(int account_id) {
        return messageInterface.registeredUserMessages(account_id);
    }

    public Message updatMessageById(int message_id, String message_text) {
        if (!(message_text.isBlank() && message_text.isEmpty()) && message_text.length() <= 255) {
            Message foundMessage = messageInterface.getMessageById(message_id);
            if (foundMessage != null) {
                messageInterface.updatMessageByid(message_id, message_text);
                foundMessage.setMessage_text(message_text);
                return foundMessage;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    public Message deleteMessageById(int message_id) {
        Message foundMessage = messageInterface.getMessageById(message_id);
        if (foundMessage != null) {
            messageInterface.deleteMessageById(message_id);
            return foundMessage;
        } else {
            return null;
        }
    }
}
