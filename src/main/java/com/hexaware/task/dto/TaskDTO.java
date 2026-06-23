package com.hexaware.task.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskDTO {
	
	private String title;
	
	private String description;
	
	private LocalDate dueDate;
	
	private String priority;
	
	private String status;

}
