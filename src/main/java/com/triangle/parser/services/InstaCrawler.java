package com.triangle.parser.services;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.triangle.parser.models.Post;

@Service
public class InstaCrawler implements ICrawler {

	private static final String URL = "https://www.instagram.com/explore/tags/%s/?__a=1";
	
	private RestTemplate restTemplate = new RestTemplate();

	@Override
	public List<Post> getPosts(String hashtag, int count) {
		List<Post> posts = new ArrayList<>();
		String data = restTemplate.getForEntity(String.format(URL, hashtag), String.class).getBody();
		JsonElement main = new JsonParser().parse(data);
		JsonObject graphql = main.getAsJsonObject().getAsJsonObject("graphql");
		JsonObject hashtagEl = graphql.getAsJsonObject("hashtag");
		JsonObject edgeAllPosts = hashtagEl.getAsJsonObject("edge_hashtag_to_media");
		JsonArray edges = edgeAllPosts.getAsJsonArray("edges");
		
		if(count > edges.size()) {
			count = edges.size();
		}
		
		for(int i = 0; i < count; i++) {
			JsonObject nodeWrapper =  edges.get(i).getAsJsonObject();
			JsonObject node = nodeWrapper.getAsJsonObject("node");
			JsonArray innderEdges = node.getAsJsonObject("edge_media_to_caption").getAsJsonArray("edges");
			System.out.println("Shortcode:" + node.get("shortcode").getAsString());
			String text = "";
			if(innderEdges.size() > 0) {
				text = innderEdges.get(0).getAsJsonObject().getAsJsonObject("node").get("text").getAsString();
			}
			Integer likes = node.getAsJsonObject().getAsJsonObject("edge_liked_by").get("count").getAsInt();
			String image = node.getAsJsonObject().get("display_url").getAsString();
			Long timestamp = node.get("taken_at_timestamp").getAsLong();
			Post post = new Post();
			post.setInstaId(node.get("id").getAsString());
			post.setShortCode(node.get("shortcode").getAsString());
			post.setText(text);
			post.setDate(LocalDateTime.ofInstant(Instant.ofEpochSecond(timestamp), 
                    TimeZone.getDefault().toZoneId()));
			post.setLikesCount(likes);
			post.setImageUrl(image);
			posts.add(post);
		}
		
		return posts;
	}
	
}
