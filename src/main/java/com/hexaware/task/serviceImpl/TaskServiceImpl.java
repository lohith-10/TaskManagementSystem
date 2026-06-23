package com.hexaware.task.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.task.dto.TaskDTO;
import com.hexaware.task.entity.Task;
import com.hexaware.task.repository.TaskRepository;
import com.hexaware.task.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService{
	
	@Autowired
	private TaskRepository taskRepository;
	
	@Override
	public TaskDTO addTask(TaskDTO dto) {
		
		Task task = new Task();
		
		task.setTitle(dto.getTitle());
		task.setDescription(dto.getDescription());
		task.setDueDate(dto.getDueDate());
		task.setPriority(dto.getPriority());
		task.setStatus(dto.getStatus());
		
		Task savedTask = taskRepository.save(task); //entity class task will store the objects in repo
		
		TaskDTO responseDto = new TaskDTO();
		
		responseDto.setTitle(savedTask.getTitle());
		responseDto.setDescription(savedTask.getDescription());
		responseDto.setDueDate(savedTask.getDueDate());
		responseDto.setPriority(savedTask.getPriority());
		responseDto.setStatus(savedTask.getStatus());
		
		return responseDto;
		
				
				
	}


	@Override
	public TaskDTO updateTask(Long taskId, TaskDTO dto) {
		
		Task task = taskRepository.findById(taskId).orElse(null);
		
		task.setTitle(dto.getTitle());
		task.setDescription(dto.getDescription());
		task.setDueDate(dto.getDueDate());
		task.setPriority(dto.getPriority());
		task.setStatus(dto.getStatus());
		
		Task updatedTask = taskRepository.save(task);
		
		TaskDTO responseDto = new TaskDTO();
		
        responseDto.setTitle(updatedTask.getTitle());
        responseDto.setDescription(updatedTask.getDescription());
        responseDto.setDueDate(updatedTask.getDueDate());
        responseDto.setPriority(updatedTask.getPriority());
        responseDto.setStatus(updatedTask.getStatus());

        return responseDto;
		
		
	}

	@Override
	public TaskDTO getTaskById(Long taskId) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        TaskDTO dto = new TaskDTO();

        dto.setTitle(task.getTitle());
        dto.setDescription(task.getDescription());
        dto.setDueDate(task.getDueDate());
        dto.setPriority(task.getPriority());
        dto.setStatus(task.getStatus());

        return dto;
	}

	@Override
	public List<TaskDTO> getAllTasks() {
        List<Task> tasks = taskRepository.findAll();

        List<TaskDTO> dtoList = new ArrayList<>();

        for (Task task : tasks) {

            TaskDTO dto = new TaskDTO();

            dto.setTitle(task.getTitle());
            dto.setDescription(task.getDescription());
            dto.setDueDate(task.getDueDate());
            dto.setPriority(task.getPriority());
            dto.setStatus(task.getStatus());

            dtoList.add(dto);
        }

        return dtoList;
    }

	@Override
	public void deleteTask(Long taskId) {
		taskRepository.deleteById(taskId);
		
	}

}
