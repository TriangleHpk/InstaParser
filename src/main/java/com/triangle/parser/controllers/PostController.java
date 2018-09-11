package com.triangle.parser.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.Entities;
import org.springframework.social.twitter.api.HashTagEntity;
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

	ArrayList<Post> posts = new ArrayList<Post>();
	ObjectId oid = new ObjectId();
	Date createdAt = new Date();
	String profileImageUrl = "https://freeiconshop.com/wp-content/uploads/edd/person-flat.png";
	int[] indices = {1,2,3};
	HashTagEntity hashTagEntity = new HashTagEntity("#hello", indices);
	HashTagEntity hashTagEntity1 = new HashTagEntity("#dude", indices);
	HashTagEntity hashTagEntity2 = new HashTagEntity("#java", indices);
	List<HashTagEntity> list= new ArrayList<HashTagEntity>();
	list.add(hashTagEntity);
	list.add(hashTagEntity1);
	list.add(hashTagEntity2);
	Entities entities = new Entities(null, list, null, null);
	
	Post post1 = new Post(oid, 1l, oid, "hello is a text", createdAt, "John123", profileImageUrl, "source", 4, true, true, 6, entities);
	Post post2 = new Post(oid, 2l, oid, "hello is a text", createdAt, "Lina123", profileImageUrl, "source", 5, true, true, 5, entities);
	Post post3 = new Post(oid, 3l, oid, "hello is a text", createdAt, "Lucy123", profileImageUrl, "source", 6, true, true, 4, entities);
	posts.add(post1);
	posts.add(post2);
	posts.add(post3);
	
	if (id.equals(oid)) {
		return posts;
	}
		return null;
		
	}
	
}
