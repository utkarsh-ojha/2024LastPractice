package com.recallspringboot.utkarsh.taskManagement.repository;

import com.recallspringboot.utkarsh.taskManagement.entity.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TasksRepository extends JpaRepository<Tasks, Long> {

}
