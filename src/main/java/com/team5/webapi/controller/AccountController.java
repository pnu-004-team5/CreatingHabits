package com.team5.webapi.controller;

import java.util.List;

import com.team5.webapi.model.Account_info;
import com.team5.webapi.repository.AccountRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountRepository accountRepository;

    @RequestMapping(value = "/signup", method = { RequestMethod.GET })
    public Account_info signUp(Account_info account_info) {
        Account_info accountData = accountRepository.save(account_info);

        return accountData;
    }

    @RequestMapping(value="/login", method=RequestMethod.GET)
    public String logIn(Account_info account_info) {
        Boolean match = true;
        // Account_info accountData = accountRepository.save(account_info);

        if (match)
            return "Login Complete";
        else
            return "Login Failed";
    }


    @RequestMapping("/logout")
    public String logOut(Account_info account_info) {
        
        return "Logout Complete";
    }

    @RequestMapping("/quit")
    public String quitAccount(Account_info account_info) {
        // Account_info accountData = accountRepository.save(account_info);

        return "Account quit complete";
    }


    @RequestMapping("/showall")
    public List<Account_info> getAccounts(Model model) {
        List<Account_info> accountList = accountRepository.findAll();

        return accountList;
    }
    
}