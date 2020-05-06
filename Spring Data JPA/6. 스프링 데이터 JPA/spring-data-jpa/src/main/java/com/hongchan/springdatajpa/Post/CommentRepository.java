package com.hongchan.springdatajpa.Post;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long>, JpaSpecificationExecutor<Comment> {

    @EntityGraph(value = "Comment.post")
//    @EntityGraph(attributePaths = "post")
    Optional<Comment> getById(Long id);

    <T> Optional<T> findByPost_Id(Long id, Class<T> type);
//    Optional<CommentSummary> findByPost_Id(Long id);
}
