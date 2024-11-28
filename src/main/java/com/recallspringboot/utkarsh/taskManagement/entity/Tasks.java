package com.recallspringboot.utkarsh.taskManagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Tasks {
    @Id
    @GeneratedValue
    public long id;
    public String title;
    public String description;
    public String priority;
    public String dueDate;
    public String assignedToUser;

}
