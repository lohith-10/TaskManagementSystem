package com.hexaware.task.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hexaware.task.dto.TaskDTO;

@Service
public interface TaskService {
	
	TaskDTO addTask(TaskDTO dto);
	
	TaskDTO updateTask(Long taskId, TaskDTO dto);
	
	TaskDTO getTaskById(Long taskId);
	
	List<TaskDTO> getAllTasks();
	
	void deleteTask(Long taskId);

}
