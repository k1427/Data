// package com.prjgrp.artf.controller;

// import com.prjgrp.artf.entity.Forum;
// import com.prjgrp.artf.entity.RepairGuide;
// import com.prjgrp.artf.service.ForumService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;
// import java.util.Optional;

// @RestController
// @RequestMapping("/forums")
// public class ForumController {

//     @Autowired
//     private ForumService forumService;

//     @GetMapping
//     public ResponseEntity<List<Forum>> getAllForumPosts() {
//     List<Forum> forums = forumService.getAllForumPosts();
//     return ResponseEntity.ok(forums);
// }
// @DeleteMapping("/{id}")
// public ResponseEntity<Void> deleteForumPost(@PathVariable Long id) {
//     forumService.deleteForumPost(id);
//     return ResponseEntity.noContent().build();
// }

// // @PostMapping
// // public ResponseEntity<RepairGuide> createRepairGuide(@RequestBody RepairGuide repairGuide) {
// //     RepairGuide createdGuide = repairGuideService.createRepairGuide(repairGuide);
// //     return new ResponseEntity<>(createdGuide, HttpStatus.CREATED);
// //}

// // @GetMapping
// // public ResponseEntity<List<Forum>> getAllForumPosts() {
// //     List<Forum> forums = forumService.getAllForumPosts();
// //     return ResponseEntity.ok(forums);
// // }

// //     @PostMapping
// //     public ResponseEntity<Forum> createForumPost(@RequestBody Forum forum) {
// //         Forum createdForum = forumService.createForumPost(forum);
// //         return new ResponseEntity<>(createdForum, HttpStatus.CREATED);
// //     }

// //     @GetMapping
// //     public ResponseEntity<List<Forum>> getAllForumPosts() {
// //         List<Forum> forums = forumService.getAllForumPosts();
// //         return ResponseEntity.ok(forums);
// //     }

// //     @GetMapping("/{id}")
// //     public ResponseEntity<Forum> getForumPostById(@PathVariable Long id) {
// //         Optional<Forum> forum = forumService.getForumPostById(id);
// //         return forum.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
// //     }

// //     @DeleteMapping("/{id}")
// //     public ResponseEntity<Void> deleteForumPost(@PathVariable Long id) {
// //         forumService.deleteForumPost(id);
// //         return ResponseEntity.noContent().build();
// //     }
//  }


package com.prjgrp.artf.controller;

import com.prjgrp.artf.entity.Forum;
import com.prjgrp.artf.service.ForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/forums") // Make sure this matches the test URL
public class ForumController {

    @Autowired
    private ForumService forumService;

    // Endpoint to create a new forum post
    @PostMapping
    public ResponseEntity<Forum> createForumPost(@RequestBody Forum forum) {
        Forum createdForum = forumService.createForumPost(forum);
        return new ResponseEntity<>(createdForum, HttpStatus.CREATED);
    }

    // Endpoint to retrieve all forum posts
    @GetMapping
    public ResponseEntity<List<Forum>> getAllForumPosts() {
        List<Forum> forums = forumService.getAllForumPosts();
        return ResponseEntity.ok(forums);
    }

    // Endpoint to retrieve a specific forum post by ID
    @GetMapping("/{id}")
    public ResponseEntity<Forum> getForumPostById(@PathVariable Long id) {
        Optional<Forum> forum = forumService.getForumPostById(id);
        return forum.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Endpoint to delete a forum post by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteForumPost(@PathVariable Long id) {
        forumService.deleteForumPost(id);
        return ResponseEntity.noContent().build();
    }
    
}
