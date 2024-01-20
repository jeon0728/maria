package com.example.maria.controller

import com.example.maria.Entity.PostEntity
import com.example.maria.service.PostService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/posts")
class PostController {

    @Autowired
    private lateinit var postService: PostService

    @GetMapping
    fun getAllPosts(): ResponseEntity<List<PostEntity>> {
        val posts = postService.getAllPosts()
        return ResponseEntity(posts, HttpStatus.OK)
    }

    @PostMapping("/create")
    fun createPost(@RequestBody postEntity: PostEntity): ResponseEntity<PostEntity> {
        val createdPost = postService.createPost(postEntity.name, postEntity.age)
        return ResponseEntity(createdPost, HttpStatus.CREATED)
    }

    @GetMapping("/{id}")
    fun getPostById(@PathVariable id: Long): ResponseEntity<PostEntity?> {
        val post = postService.getPostById(id)
        return if (post != null) {
            ResponseEntity(post, HttpStatus.OK)
        } else {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    @PutMapping("/{id}")
    fun updatePost(
        @PathVariable id: Long,
        @RequestParam name: String,
        @RequestParam age: Int
    ): ResponseEntity<PostEntity?> {
        val updatedPost = postService.updatePost(id, name, age)
        return if (updatedPost != null) {
            ResponseEntity(updatedPost, HttpStatus.OK)
        } else {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    @DeleteMapping("/{id}")
    fun deletePost(@PathVariable id: Long): ResponseEntity<Unit> {
        val isDeleted = postService.deletePost(id)
        return if (isDeleted) {
            ResponseEntity(HttpStatus.NO_CONTENT)
        } else {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }
}