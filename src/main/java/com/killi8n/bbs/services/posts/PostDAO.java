package com.killi8n.bbs.services.posts;

import java.util.List;

import com.killi8n.bbs.models.Post;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PostDAO {

    @Autowired
    private SqlSessionTemplate session;
    private String namespace = "com.killi8n.bbs.PostMapper";

    public void create(Post post) {
        session.insert(namespace + ".create", post);
    }

    public List<Post> pagedList(int page) {
        return session.selectList(namespace + ".pagedList", page);
    }

    public Post read(Long id) {
        return session.selectOne(namespace + ".read", id);
    }

    public void remove(Long id) {
        session.delete(namespace + ".remove", id);
    }

    public void update(Post post) {
        session.update(namespace + ".update", post);
    }

}