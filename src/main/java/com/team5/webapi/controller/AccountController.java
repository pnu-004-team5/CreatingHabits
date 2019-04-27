package com.team5.webapi.controller;

import java.util.List;

import javax.servlet.http.Cookie;

import com.team5.webapi.model.Account_info;
import com.team5.webapi.repository.AccountRepository;

import org.apache.tomcat.util.descriptor.web.LoginConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

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

    // @RequestMapping(value="/login", method=RequestMethod.GET)
    // public ModelAndView logIn(Account_info account_info) throws Exception {
    //     Account_info accountData = accountRepository.save(account_info);
    //     Account_info.setId(rememberCookie.getValue);
    //         ((Object) loginCommand).setRememberId(true);
        
        
    //     ModelAndView mv = new ModelAndView("/account/login/logIn");
    //     return mv;
    // }


    // @RequestMapping("/logout")


    @RequestMapping("/showall")
    public List<Account_info> getAccounts(Model model) {
        List<Account_info> accountList = accountRepository.findAll();

        return accountList;
    }
    
}