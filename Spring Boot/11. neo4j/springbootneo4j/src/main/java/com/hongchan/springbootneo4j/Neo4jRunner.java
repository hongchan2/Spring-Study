package com.hongchan.springbootneo4j;

import com.hongchan.springbootneo4j.account.Account;
import com.hongchan.springbootneo4j.account.Role;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class Neo4jRunner implements ApplicationRunner {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Account account = new Account();
        account.setUsername("jiyun");
        account.setEmail("ji@naver.com");

        Role role = new Role();
        role.setName("hongchan");
        account.getRoles().add(role);

        final Session session = sessionFactory.openSession();
        session.save(account);
        sessionFactory.close();

        System.out.println("Finished");
    }
}
