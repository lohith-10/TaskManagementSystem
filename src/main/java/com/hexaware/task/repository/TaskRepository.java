package com.hexaware.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.task.entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long>{
	

}
