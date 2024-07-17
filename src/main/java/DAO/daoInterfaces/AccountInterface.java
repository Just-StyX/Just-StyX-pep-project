package DAO.daoInterfaces;

import Model.Account;

public interface AccountInterface {
    Account register(Account account);
    Account loging(Account account);
    Account getAccountById(int account_id);
}
