package com.springboot.example.async.runner;

import com.springboot.example.async.domain.Account;
import com.springboot.example.async.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

@Slf4j
@Component
public class AppRunner implements CommandLineRunner {

    @Autowired
    AccountService accountService;

    @Override
    public void run(String... args) throws Exception {

        long start = System.currentTimeMillis();
        Future<Account> page1 = accountService.asyncAccount(1);
        Future<Account> page2 = accountService.asyncAccount(2);
        Future<Account> page3 = accountService.asyncAccount(3);

        //wait until all done .
        while (!(page1.isDone() && page2.isDone() && page3.isDone())) {
            Thread.sleep(10);
        }
        // Print results, including elapsed time
        log.info("Elapsed time: " + (System.currentTimeMillis() - start));
        log.info("--> " + page1.get());
        log.info("--> " + page2.get());
        log.info("--> " + page3.get());
    }
}
