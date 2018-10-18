package com.killi8n.bbs.services.accounts;

import com.killi8n.bbs.models.Account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements AccountServiceInterface {
    @Autowired
    AccountDAO accountDAO;

    public void register(Account account) {
        accountDAO.register(account);
    }

    public Account checkExistingUsername(String username) {
        return accountDAO.checkExistingUsername(username);
    }

    public Account checkExistingEmail(String email) {
        return accountDAO.checkExistingEmail(email);
    }
}