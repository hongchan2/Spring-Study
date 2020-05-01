package com.hongchan.demospringdata;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
class PostRepositoryTest {

    public static final String STRING = "31";
    @Autowired
    PostRepository postRepository;

    @Test
    @Rollback(false)
    public void curdRepository() {
        // Given
        Post post = new Post();
        post.setTitle("Title1");
        assertThat(post.getId()).isNull();

        // When
        Post newPost = postRepository.save(post);
        // Then
        assertThat(newPost.getId()).isNotNull();

        // When
        List<Post> posts = postRepository.findAll();
        // Then
        assertThat(posts.size()).isEqualTo(1);
        assertThat(posts.contains(newPost));

        // When
        Page<Post> page = postRepository.findAll(PageRequest.of(0, 10));
        // Then
        assertThat(page.getTotalElements()).isEqualTo(1);
        assertThat(page.getNumberOfElements()).isEqualTo(1);
    }

}