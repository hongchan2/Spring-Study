package com.hongchan.datajpacommon.Post;

import java.util.List;

public interface PostCustomRepository<T> {

    List<Post> findMyPost();

    void delete(T post);
}
