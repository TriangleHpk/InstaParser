package com.triangle.parser.models;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document
@Data
public class Task {
	@Id
	private ObjectId id;
	private List<String> hashtags;
	private Integer period;
	
}
