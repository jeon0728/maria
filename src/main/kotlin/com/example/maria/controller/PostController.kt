package com.example.maria.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/")
class PostController {

    //HTTP GET 요청이 /posts 경로로 들어오면 이 메서드가 처리합니다.
    @GetMapping("posts")
    fun getPosts(): String {
        return "hello world!!"
    }
}