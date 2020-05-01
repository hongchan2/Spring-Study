package com.hongchan.demospringdata;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
class CommentRepositoryTest {

    @Autowired
    CommentRepository repository;

    @Test
    public void crud() {
        // 1
//        Optional<Comment> byId = repository.findById(10l);
//        assertThat(byId).isEmpty();
//        Comment comment = byId.orElse(new Comment());
//        Comment comment1 = byId.orElseThrow();

        // 2
        this.createComment("spring jpa1", 100);
        this.createComment("spring jpa2", 44);

        List<Comment> comments = repository.findByCommentContainsIgnoreCaseOrderByLikeCountDesc("Spring");
        assertThat(comments.size()).isEqualTo(2);
        assertThat(comments).first().hasFieldOrPropertyWithValue("likeCount", 100);
    }

    private void createComment(String comm, int likeCount) {
        Comment comment = new Comment();
        comment.setComment(comm);
        comment.setLikeCount(likeCount);
        repository.save(comment);
    }

}