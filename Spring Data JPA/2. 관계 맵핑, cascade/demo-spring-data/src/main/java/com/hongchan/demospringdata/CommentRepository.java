package com.hongchan.demospringdata;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.scheduling.annotation.Async;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.Future;
import java.util.stream.Stream;

//@RepositoryDefinition(domainClass = Comment.class, idClass = Long.class)
//public interface CommentRepository {
//
//    Comment save(Comment comment);
//
//    List<Comment> findAll();
//
//    Optional<Comment> findById(Long id);
//
//}

public interface CommentRepository extends JpaRepository<Comment, Long> {

//    List<Comment> findByCommentContainsIgnoreCase(String comment);

    List<Comment> findByCommentContainsIgnoreCaseAndLikeCountGreaterThan(String comment, int likeCount);

    List<Comment> findByCommentContainsIgnoreCaseOrderByLikeCountDesc(String comment);

//    Page<Comment> findByCommentContainsIgnoreCase(String comment, Pageable pageable);

//    Stream<Comment> findByCommentContainsIgnoreCase(String comment, Pageable pageable);

    @Async
    Future<Comment> findByCommentContainsIgnoreCase(String comment, Pageable pageable);

}