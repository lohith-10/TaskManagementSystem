package com.hexaware.task.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.task.dto.TaskDTO;
import com.hexaware.task.service.TaskService;

import jakarta.validation.Valid;

@RestController
public class TaskController {
	
	@Autowired
	private TaskService taskService;
	
	@PostMapping("/add")
	public TaskDTO addTask(@Valid @RequestBody TaskDTO dto) {
		return taskService.addTask(dto);
	}
	
	@PutMapping("/update/{taskId}")
	public TaskDTO updateTask(@PathVariable Long taskId, @RequestBody TaskDTO dto) {
		return taskService.updateTask(taskId, dto);
	}
	
	@GetMapping("/{taskId}")
	public TaskDTO getTaskById(@PathVariable Long taskId) {
		return taskService.getTaskById(taskId);
	}
	
	@GetMapping("/all")
	public List<TaskDTO> getAllTasks(){
		
		return taskService.getAllTasks();
	}
	
	@DeleteMapping("/delete/{taskId}")
	public void deleteTask(@PathVariable Long taskId) {
		taskService.deleteTask(taskId);
	}
	
	

}
