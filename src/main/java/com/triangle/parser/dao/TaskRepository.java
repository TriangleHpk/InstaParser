package com.triangle.parser.dao;

import org.bson.types.ObjectId;
import org.springframework.data.repository.CrudRepository;

import com.triangle.parser.models.Task;

public interface TaskRepository extends CrudRepository<Task, ObjectId>{

}
