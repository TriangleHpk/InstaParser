package com.triangle.parser.controllers;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.triangle.parser.models.Task;
import com.triangle.parser.services.TaskService;

@RestController
public class TaskController {
	
	@Autowired
	private TaskService taskService;

	/*
	 * Controller returns Posts saved into DB
	 */
	@GetMapping(value = "/task/{id}")
	private Task getTaskById(@PathVariable ObjectId id) {
		return taskService.getTaskById(id);
	}

	/*
	 * Controller returns Response if task created and saved
	 */
	@PostMapping(value = "/task/create")
	public String createTask(@RequestBody Task task) {
		return taskService.createTask(task).toHexString();
	}

}
