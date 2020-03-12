package com.hongchan.springbootredis;

import com.hongchan.springbootredis.account.Account;
import com.hongchan.springbootredis.account.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RedisRunner implements ApplicationRunner {

    @Autowired
    StringRedisTemplate redisTemplate;

    @Autowired
    AccountRepository repository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        final ValueOperations<String, String> values = redisTemplate.opsForValue();
        values.set("hongchan", "jiyun");
        values.set("hello", "world");
        values.set("spring boot", "2.0");

        Account account = new Account();
        account.setUsername("hongchan");
        account.setEmail("hongchan@naver.com");

        repository.save(account);
        final Optional<Account> byId = repository.findById(account.getId());

        System.out.println(byId.get().getUsername());
        System.out.println(byId.get().getEmail());
    }
}
