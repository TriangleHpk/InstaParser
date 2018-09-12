package com.triangle.parser.dao;

import org.bson.types.ObjectId;
import org.springframework.data.repository.CrudRepository;

import com.triangle.parser.models.Post;

public interface PostRepository extends CrudRepository<Post,ObjectId>{

}
