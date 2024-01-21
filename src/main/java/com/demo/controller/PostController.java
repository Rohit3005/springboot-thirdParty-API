package com.demo.controller;

import com.demo.service.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class PostController {

    @Autowired
    PostServiceImpl service;

    @GetMapping("/getpost")
    public List<Map<String, Object>> getPost(){
        return service.getPost();
    }

    @GetMapping("/getpost/{id}")
    public Map<String, Object> getPost(@PathVariable int id){
        return service.getPostById(id);
    }
}
