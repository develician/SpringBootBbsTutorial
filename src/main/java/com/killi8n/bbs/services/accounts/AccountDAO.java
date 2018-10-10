package com.killi8n.bbs.services.accounts;

import com.killi8n.bbs.models.Account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAO {
   @Autowired
   JdbcTemplate jdbcTemplate;

   public long register(Account account) {
       String sql = "INSERT INTO accounts (username, password, email, createdAt) values (?, ?, ?, ?)";
       int registered = jdbcTemplate.update(sql, new Object[] {
           account.getUsername(),
           account.getPassword(),
           account.getEmail(),
           account.getCreatedAt()
       });
       long accountCount = 0;
       if (registered == 1) {
            accountCount = jdbcTemplate.queryForObject("SELECT MAX(id) FROM accounts", Long.class);
       }
       return accountCount;
   }

   
}