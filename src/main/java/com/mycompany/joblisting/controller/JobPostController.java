package com.mycompany.joblisting.controller;

import javax.servlet.http.HttpServletResponse;

import com.mycompany.joblisting.repository.JobPostRepository;
import com.mycompany.joblisting.model.JobPost;
import com.mycompany.joblisting.repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.io.IOException;
import java.util.List;

@RestController
public class JobPostController {

    @Autowired
    JobPostRepository repo;

    @Autowired
    SearchRepository srepo;

    @ApiIgnore
    @RequestMapping(value = "/")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }

    @GetMapping("/posts")
    public List<JobPost> getAllJobPosts() {
        return repo.findAll();
    }

    @GetMapping("/posts/{text}")
    public List<JobPost> search(@PathVariable String text) {
        return srepo.findByText(text);
    }

    @PostMapping("/post")
    public JobPost addPost(@RequestBody JobPost post) {
        return repo.save(post);
    }
}
