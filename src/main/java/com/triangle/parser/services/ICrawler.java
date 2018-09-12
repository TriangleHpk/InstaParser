package com.triangle.parser.services;

import java.util.List;

import com.triangle.parser.models.Post;

public interface ICrawler {
	
	public List<Post> getPosts(String hashtag, int count);
}
