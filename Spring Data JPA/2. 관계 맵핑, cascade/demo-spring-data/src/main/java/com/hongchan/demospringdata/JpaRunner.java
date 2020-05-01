package com.hongchan.demospringdata;

import org.hibernate.Session;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
@Transactional
public class JpaRunner implements ApplicationRunner {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // 1
//        Account account = new Account();
//        account.setUsernmae("hongchan");
//        account.setPassword("1234");
//
//        Study study = new Study();
//        study.setName("Spring");
//
//        account.addStudy(study);
//
//        Session session = entityManager.unwrap(Session.class);
//        session.save(account);
//        session.save(study);

        // 2
        Post post = new Post();
        post.setTitle("This is Title");

        Comment comment = new Comment();
        comment.setComment("comment");
        post.addComment(comment);

        Comment comment1 = new Comment();
        comment1.setComment("comment1");
        post.addComment(comment1);

        Session session = entityManager.unwrap(Session.class);
        session.save(post);

        // 3
//        TypedQuery<Post> query = entityManager.createQuery("SELECT p From Post As p", Post.class);
//        List<Post> posts = query.getResultList();
//        posts.forEach(System.out::println);
        List<Post> posts = entityManager.createNativeQuery("SELECT * FROM POST", Post.class).getResultList();
        posts.forEach(System.out::println);
    }
}
