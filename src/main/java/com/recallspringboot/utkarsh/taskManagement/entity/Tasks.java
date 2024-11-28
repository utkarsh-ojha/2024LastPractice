package com.recallspringboot.utkarsh.taskManagement.entity;

import com.recallspringboot.utkarsh.userManagement.entity.Users;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Tasks")
public class Tasks {
    @Id
    @GeneratedValue
    public long id;
    public String title;
    public String description;
    public String priority;
    public String dueDate;
    @ManyToOne
    @JoinColumn(name = "assigned_to_user_id")
    public Users assignedToUser;
}
