package com.hongchan.springdatajpa.Post;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CommentRepositoryTest {

    @Autowired
    CommentRepository commentRepository;

    @Test
    public void doTest() {
        commentRepository.getById(1l);

        System.out.println("=========");

        commentRepository.findById(1l);
    }

    @Test
    public void projectionTest() {
//        commentRepository.findByPost_Id(1l);
    }

    @Test
    public void specs() {
        commentRepository.findAll(CommentSpecs.isBest().or(CommentSpecs.isGood()));
    }

}