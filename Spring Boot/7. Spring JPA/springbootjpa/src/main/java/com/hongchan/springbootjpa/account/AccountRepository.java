package com.hongchan.springbootjpa.account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    // 실제 구현체를 만들고 빈으로 만드는 것은 스프링 JPA가 알아서 해줌
    // 따라서 JDBC를 쓰는 경우는 거의 없고 JPA를 주로 사용함
    // 쿼리를 사용해야 하는 경우에도 JPA에서 사용 가능 (@Query)
//    @Query(nativeQuery = true, value = "select * from account where username = '{0}'")
    Optional<Account> findByUsername(String username);

}
