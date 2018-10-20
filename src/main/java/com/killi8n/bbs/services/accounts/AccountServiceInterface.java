package com.killi8n.bbs.services.accounts;

import com.killi8n.bbs.models.Account;

public interface AccountServiceInterface {
    public void register(Account account);

    public Account checkExistingUsername(String username);

    public Account checkExistingEmail(String email);

}