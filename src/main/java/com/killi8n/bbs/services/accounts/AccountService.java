package com.killi8n.bbs.services.accounts;

import com.killi8n.bbs.models.Account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    AccountDAO accountDAO;

    public long register(Account account) {
        return accountDAO.register(account);
    }
}