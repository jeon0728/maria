package com.example.maria.controller

import com.example.maria.service.PostService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping

@Controller
class ViewController {

    @Autowired
    private lateinit var postService: PostService

    @GetMapping("/view")
    fun view(model: Model): String {
        model["title"] = "maria DB Project"
        val posts = postService.getAllPosts()
        /*for (item in posts) {
            model["name"] = item.name;
            model["age"] = item.age;
        }*/
        model["posts"] = posts
        return "contents"
    }
}