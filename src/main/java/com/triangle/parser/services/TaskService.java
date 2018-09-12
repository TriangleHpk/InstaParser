package com.triangle.parser.services;

import java.util.ArrayList;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.triangle.parser.dao.TaskRepository;
import com.triangle.parser.models.Task;

@Service
public class TaskService {
	
	@Autowired
	private TaskRepository repository;

	public ObjectId createTask(Task task) {
		repository.save(task);
		ArrayList<Task> tasks = (ArrayList<Task>) repository.findAll();
		return tasks.stream().filter(eachTask -> eachTask.equals(task)).findFirst().get().getId();
	}
	
	public Task getTaskById(ObjectId id) {
		return repository.findById(id).get();
	}
}
