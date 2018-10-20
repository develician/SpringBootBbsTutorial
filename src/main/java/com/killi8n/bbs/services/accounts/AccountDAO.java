package com.killi8n.bbs.services.accounts;

import com.killi8n.bbs.models.Account;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAO {
    @Autowired
    private SqlSessionTemplate session;
    private String namespace = "com.killi8n.bbs.AccountMapper";

    public void register(Account account) {
        session.insert(namespace + ".register", account);
    }

    public Account checkExistingUsername(String username) {
        return session.selectOne(namespace + ".checkExistingUsername", username);
    }

    public Account checkExistingEmail(String email) {
        return session.selectOne(namespace + ".checkExistingEmail", email);
    }

}