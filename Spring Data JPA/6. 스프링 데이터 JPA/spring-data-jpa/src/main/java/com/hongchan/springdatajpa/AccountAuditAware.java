package com.hongchan.springdatajpa;

import com.hongchan.springdatajpa.Post.Account;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountAuditAware implements AuditorAware<Account> {
    @Override
    public Optional<Account> getCurrentAuditor() {
        System.out.println("Loocking for current User at spring security");
        return Optional.empty();
    }
}
