package com.killi8n.bbs.controllers;

import java.util.Map;

import com.killi8n.bbs.lib.HashPassword;
import com.killi8n.bbs.models.Account;
import com.killi8n.bbs.services.accounts.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/api/v1/auth")
@Controller
public class AuthController {

    @Autowired
    AccountService accountService;

    @Autowired 
    HashPassword hashPassword;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> register(Account account, @RequestBody Map<String, String> requestBody) {
        String username = requestBody.get("username");
        String password = requestBody.get("password");
        String email = requestBody.get("email");

        // TODO: Check existing ID;
        // TODO: Check Validation Of Form Inputs;

        try {
            String hashedPassword = hashPassword.encrypt(password);
            account = new Account();
            account.setUsername(username);
            account.setPassword(hashedPassword);
            account.setEmail(email);
            return new ResponseEntity<>("Register", HttpStatus.OK);
        } catch(Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> login() {
        return new ResponseEntity<>("Login", HttpStatus.OK);
    }
}