package com.hongchan.springdatajpa.Post;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.JpaSort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;

    @Test
    public void findTitle() {
        Post post = new Post();
        post.setTitle("hongchan jiyun");
        postRepository.save(post);

//        List<Post> found = postRepository.findByTitle("hongchan jiyun", Sort.by("title"));
        List<Post> found = postRepository.findByTitle("hongchan jiyun", JpaSort.unsafe("LENGTH(title)"));
        assertThat(found.size()).isEqualTo(1);
    }

}