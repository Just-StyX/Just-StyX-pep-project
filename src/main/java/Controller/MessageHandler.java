package Controller;

import Model.Message;
import Service.MessageService;
import io.javalin.http.Handler;

public class MessageHandler {
    private static final MessageService messageService = new MessageService();

    public static Handler createMessage = context -> {
        var messageClass = context.bodyAsClass(Message.class);
        var createdMessage = messageService.creatMessage(messageClass);

        if (createdMessage != null) {
            context.json(createdMessage);
        } else {
            context.status(400);
        }
    };

    public static Handler getAllMessages = context -> {
        context.json(messageService.getAllMessages());
    };

    public static Handler getMessageByMessageId = context -> {
        var message = messageService.getMessageByMessageId(Integer.valueOf(context.pathParam("message_id")));
        if (message != null) {
            context.json(message);
        } else {
            context.status(200);
        }
    };

    public static Handler registeredAccountMessages = context -> {
        context.json(messageService.registeredUserMessages(Integer.valueOf(context.pathParam("account_id"))));
    };

    public static Handler updateMessage = context -> {
        String message_text = context.bodyAsClass(Message.class).getMessage_text();
        var updatedMessage = messageService.updatMessageById(Integer.valueOf(context.pathParam("message_id")), message_text);

        if (updatedMessage != null) {
            context.json(updatedMessage);
        } else {
            context.status(400);
        }
    };

    public static Handler deleteMessageByMessageId = context -> {
        var message = messageService.deleteMessageById(Integer.valueOf(context.pathParam("message_id")));
        if (message != null) {
            context.json(message);
        } else {
            context.status(200);
        }
    };
}
