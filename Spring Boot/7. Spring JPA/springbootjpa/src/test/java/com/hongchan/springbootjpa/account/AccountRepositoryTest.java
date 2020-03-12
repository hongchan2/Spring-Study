package com.hongchan.springbootjpa.account;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
// Repository와 관련된 빈들만 등록해서 테스트
// 인메모리 데이터베이스로 테스트 (h1)
// 통합 테스트를 한다면 느리고, 테스트용 db가 필요함 (그렇게 하지 않으면 테스트 코드로 인해 디비 변경될 수 있음)
// 따라서 슬라이싱 테스트를 권장
@DataJpaTest()
public class AccountRepositoryTest {

    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    AccountRepository accountRepository;

    @Test
    public void di() throws SQLException {
        Account account = new Account();
        account.setUsername("hongchan");
        account.setPassword("pass");

        Account newAccount = accountRepository.save(account);

        assertThat(newAccount).isNotNull();

        Optional<Account> existingAccount = accountRepository.findByUsername(newAccount.getUsername());
        assertThat(existingAccount).isNotNull();

        Optional<Account> nonExistingAccount = accountRepository.findByUsername("jiyun");
        assertThat(nonExistingAccount).isEmpty();
    }
}