// package com.prjgrp.artf.service;

// import com.prjgrp.artf.entity.Forum;
// import com.prjgrp.artf.repository.ForumRepository;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import java.util.List;
// import java.util.Optional;

// @Service
// public class ForumService {

//     @Autowired
//     private ForumRepository forumRepository;

//     public Forum createForumPost(Forum forum) {
//         return forumRepository.save(forum);
//     }

//     public List<Forum> getAllForumPosts() {
//         return forumRepository.findAll();
//     }

//     public Optional<Forum> getForumPostById(Long id) {
//         return forumRepository.findById(id);
//     }

//     public void deleteForumPost(Long id) {
//         forumRepository.deleteById(id);
//     }
// }


package com.prjgrp.artf.service;

import com.prjgrp.artf.entity.Forum;
import com.prjgrp.artf.repository.ForumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ForumService {

    @Autowired
    private ForumRepository forumRepository;

    // Service method to create a new forum post
    public Forum createForumPost(Forum forum) {
        return forumRepository.save(forum);
    }

    // Service method to retrieve all forum posts
    public List<Forum> getAllForumPosts() {
        return forumRepository.findAll();
    }

    // Service method to retrieve a specific forum post by ID
    public Optional<Forum> getForumPostById(Long id) {
        return forumRepository.findById(id);
    }

    // Service method to delete a forum post by ID
    public void deleteForumPost(Long id) {
        forumRepository.deleteById(id);
    }

    
}
