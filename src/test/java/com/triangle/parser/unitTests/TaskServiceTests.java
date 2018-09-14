package com.triangle.parser.unitTests;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.triangle.parser.ParserApplication;
import com.triangle.parser.models.Task;
import com.triangle.parser.services.TaskService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ParserApplication.class })
@TestPropertySource(locations="classpath:test.properties")
public class TaskServiceTests {
	
	@Autowired
	private TaskService taskService;
	
	@Test
	public void createTaskTest() {
		Task task = new Task();
		task.setPostCount(2);
		task.setHashtags(Arrays.asList("integration","test"));
		
		Task createdTask = taskService.getTaskById(taskService.createTask(task));
		assertEquals(task,createdTask);
	}

}
