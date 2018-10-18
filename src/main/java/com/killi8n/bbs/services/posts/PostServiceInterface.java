package com.killi8n.bbs.services.posts;

import java.util.List;

import com.killi8n.bbs.models.Post;

public interface PostServiceInterface {
    public void create(Post post);

    public List<Post> pagedList(int page);

    public Post read(Long id);

    public void remove(Long id);

    public void update(Post post);
}