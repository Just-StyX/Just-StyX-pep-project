package Service;

import DAO.daoImplementation.AccountDAO;
import DAO.daoInterfaces.AccountInterface;
import Model.Account;

public class AccountService {
    AccountInterface accountInterface = new AccountDAO();

    public Account register(Account account) {
        if (!account.getUsername().isBlank() && account.getPassword().length() >= 4) {
            Account foundAccount = accountInterface.loging(account);
            if (foundAccount == null) {
                return accountInterface.register(account);
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    public Account login(Account account) {
        return accountInterface.loging(account);
    }
}
