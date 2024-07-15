package Controller;

import Model.Account;
import Service.AccountService;
import io.javalin.http.Handler;

public class AccountHandler {
    private static final AccountService accountService = new AccountService();

    public static Handler registerAccount = context -> {
        var accountClass = context.bodyAsClass(Account.class);
        var createdAccount = accountService.register(accountClass);

        if (createdAccount != null) {
            context.json(createdAccount);
        } else {
            context.status(400);
        }
    };

    public static Handler loginUser = context -> {
        var accountClass = context.bodyAsClass(Account.class);
        var login = accountService.login(accountClass);

        if (login != null) {
            context.json(login);
        } else {
            context.status(401);
        }
    };
}
