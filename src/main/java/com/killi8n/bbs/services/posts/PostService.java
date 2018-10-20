package com.killi8n.bbs.services.posts;

import java.util.List;

import com.killi8n.bbs.models.Post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService implements PostServiceInterface {

    @Autowired
    private PostDAO postDAO;

    public void create(Post post) {
        postDAO.create(post);
    }

    public List<Post> pagedList(int page) {
        return postDAO.pagedList(page);
    }

    public Post read(Long id) {
        return postDAO.read(id);
    }

    public void remove(Long id) {
        postDAO.remove(id);
    }

    public void update(Post post) {
        postDAO.update(post);
    }
}