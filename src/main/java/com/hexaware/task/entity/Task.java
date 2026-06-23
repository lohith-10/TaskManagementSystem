package com.hexaware.task.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="tasks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Task {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long taskId;
	
	private String title;
	
	private String description;
	
	private LocalDate dueDate;
	
	private String priority;
	
	private String status;

}
