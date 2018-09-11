package com.triangle.parser.models;

import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.social.twitter.api.Entities;

import lombok.Data;

@Document
@Data
public class Post {
	@Id
	private ObjectId id;
	private Long idTweet;
	private Long taskId;
	private String text;
	private final Date createdAt;
	private String fromUser;
	private String profileImageUrl;
	private String source;
	private Integer retweetCount;
	private boolean retweeted;
	private boolean favorited;
	private Integer favoriteCount;
	private Entities entities;

	public Post(ObjectId id, Long idTweet, Long taskId, String text, Date createdAt, String fromUser,
			String profileImageUrl, String source, Integer retweetCount, boolean retweeted, boolean favorited,
			Integer favoriteCount, Entities entities) {
		super();
		this.id = id;
		this.idTweet = idTweet;
		this.taskId = taskId;
		this.text = text;
		this.createdAt = createdAt;
		this.fromUser = fromUser;
		this.profileImageUrl = profileImageUrl;
		this.source = source;
		this.retweetCount = retweetCount;
		this.retweeted = retweeted;
		this.favorited = favorited;
		this.favoriteCount = favoriteCount;
		this.entities = entities;
	}

}
