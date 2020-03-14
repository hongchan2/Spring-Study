package com.hongchan.springbootsecurity2;

import com.hongchan.springbootsecurity2.account.Account;
import com.hongchan.springbootsecurity2.account.AccountRepository;
import com.hongchan.springbootsecurity2.account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class AccountRunner implements ApplicationRunner {

    @Autowired
    AccountService accountService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        final Account hongchan = accountService.createAccount("hongchan", "1234");
        System.out.println(hongchan.getUsername() + " " + hongchan.getPassword());
    }
}
