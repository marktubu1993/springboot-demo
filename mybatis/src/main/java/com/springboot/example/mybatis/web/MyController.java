package com.springboot.example.mybatis.web;

import com.springboot.example.mybatis.config.MyConfig;
import com.springboot.example.mybatis.domain.Account;
import com.springboot.example.mybatis.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author mark-liu
 */
@RestController
@RequestMapping(value = "/account")
public class MyController {

    @Autowired
    MyConfig config;

    @Autowired
    AccountService accountService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Account> getAccounts() {
        List<Account> accounts = accountService.findAccountList();
        return accounts;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Account getAccountById(@PathVariable("id") int id) {
        return accountService.findAccount(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Account updateAccount(@PathVariable("id") int id, @RequestParam(value = "name", required = true) String name,
                                 @RequestParam(value = "money", required = true) double money) {
        int t = accountService.update(name, money, id);
        if (t == 1) {
            return accountService.findAccount(id);
        } else {
            throw new RuntimeException("update fail");
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable(value = "id") int id) {
        int t = accountService.delete(id);
        if (t == 1) {
            return;
        } else {
            throw new RuntimeException("delete fail");
        }

    }

    @RequestMapping(method = RequestMethod.POST)
    public void postAccount(@RequestParam(value = "name") String name,
                            @RequestParam(value = "money") double money) {

        int t = accountService.add(name, money);
        if (t == 1) {
            return;
        } else {
            throw new RuntimeException("post fail");
        }

    }
}
