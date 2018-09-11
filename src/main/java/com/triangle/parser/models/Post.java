package com.triangle.parser.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;

@Document
@Data
@AllArgsConstructor
public class Post {
	@Id
	private ObjectId id;
	private String instaId;
	private ObjectId taskId;
	private String text;
	private String shortCode;
	private Integer likesCount;
	private String imageUrl;

}
