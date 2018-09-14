package com.triangle.parser.controllers;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.triangle.parser.models.Post;
import com.triangle.parser.services.PostService;


@RestController
public class PostController {
	
	@Autowired
	private PostService postService;
	
	/*
	 * Controller search posts in DB by task id
	 * 
	 * @param id  task id - ObjectId
	 * @return    post list
	 */
	@GetMapping(value = "/posts/{id}")
	private List<Post> getPostByTaskId(@PathVariable ObjectId id) {
		
		return postService.findByTaskId(id);
	}
	
}
