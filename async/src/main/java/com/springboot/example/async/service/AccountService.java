package com.springboot.example.async.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.example.async.dao.AccountMapper;
import com.springboot.example.async.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author mark-liu
 */
@Service
public class AccountService {
    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    ObjectMapper objectMapper = new ObjectMapper();

    public int add(String name, double money) {
        return accountMapper.add(name, money);
    }

    @Transactional(rollbackFor = Exception.class)
    public int update(String name, double money, int id) {
        accountMapper.update("test", 290, 1);
        return accountMapper.update(name, money, id);
    }

    public int delete(int id) {
        return accountMapper.delete(id);
    }

    public Account findAccount(int id) throws IOException {

        ValueOperations<Integer, String> ops = redisTemplate.opsForValue();
        String accountString = ops.get(id);

        Account account;
        if (accountString == null) {
            System.out.println("redis 未找到从数据看查询");
            account = accountMapper.findAccount(id);
            accountString = objectMapper.writeValueAsString(account);
            ops.set(id, accountString, 1, TimeUnit.MINUTES);
        }else{
            account = objectMapper.readValue(accountString, Account.class);
            System.out.println("redis：" + account);
        }
        return account;
    }

    public List<Account> findAccountList() {
        return accountMapper.findAccountList();
    }

    @Async
    public Future<Account> asyncAccount(int id) throws InterruptedException {
        Account account = accountMapper.findAccount(id);
        Thread.sleep(1000L);
        return new AsyncResult<>(account);
    }
}
